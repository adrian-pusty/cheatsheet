import DataFrameCreationExamplesTest.{Person, rddFromCsv, spark}
import FileToDataFrame.{fromCsv, fromJson}
import SeqToDataFrame.fromSeqExample
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.apache.spark.sql.{Column, DataFrame, Row, SparkSession}

import scala.Double.NaN

object ApacheSparkCheatsheet {
  def createSparkSession: SparkSession = {
    SparkSession
      .builder()
      .master("local[1]")
      .appName("app name")
      //    .config("a.b.c", "value")
      .config("spark.driver.host", "localhost") // solves: // org.apache.spark.SparkException: Invalid Spark URL: spark://HeartbeatReceiver@adrian.domain_not_set.invalid:42719
      .getOrCreate()
  }

  def sparkSqlStatementExample(spark: SparkSession, peopleDF: DataFrame): DataFrame =
  {
    peopleDF.createOrReplaceTempView("people")
    spark.sql("SELECT * FROM people WHERE age < 25")
  }

  def columnBasedOnTheGivenColumnName(): Column =
  {
    col("column_name")
  }
}

object RddToDataFrame
{
  def withColumnNamesSpecifiedExample(spark: SparkSession, tupleSeq: Seq[(String, Int, String)]): DataFrame =
  {
    val rdd = spark.sparkContext.parallelize(tupleSeq)

    import spark.implicits._
    rdd.toDF("name", "age", "sex")  // does not compile (Cannot resolve symbol toDF) if 'import spark.implicits._' is commented out // https://stackoverflow.com/a/47185056/15493760
  }

  def withNumbersAsAttributesExample(spark: SparkSession, tupleSeq: Seq[(String, Any, Any)]): DataFrame =
  {
    val rdd = spark.sparkContext.parallelize(tupleSeq)

    import spark.implicits._
    rdd.toDF
  }

  def withSchemaReflectivelyInferredExample(spark: SparkSession, personSeq: Seq[Person]): DataFrame =
  {
    val rdd = spark.sparkContext.parallelize(personSeq)

    import spark.implicits._
    rdd.toDF
  }

  def withSchemaExplicitlySpecifiedExample(spark: SparkSession): DataFrame =
  {
    val schemaString = "NAME AGE SEX"
    val fields = schemaString
      .split(" ")
      .map(fieldName => StructField(fieldName, StringType, nullable = true))
    val schema = StructType(fields)

    val rowRDD = rddFromCsv
      .map(_.split(","))
      .map(attributes => Row(attributes(0).trim, attributes(1), attributes(2)))
    spark.createDataFrame(rowRDD, schema)
  }
}

object FileToDataFrame
{
  /**
   * Note that JSON file must contain properly formatted lines.
   * Array of elements in json is not allowed and each element must take a single line to avoid AnalysisException.
   * See also: https://stackoverflow.com/a/38895521/15493760
   */
  def fromJsonExample(spark: SparkSession): DataFrame =
  {
    val path = "src/main/resources/input.json"
    fromJson(spark, path)
  }

  def fromJson(spark: SparkSession, path: String): DataFrame =
  {
    spark.read.json(path)
  }

  def fromCsvExample(spark: SparkSession): DataFrame =
  {
    val path = "src/main/resources/input.csv"
    fromCsv(spark, path)
  }

  def fromCsv(spark: SparkSession, path: String): DataFrame =
  {
    spark.read.csv(path)
  }
}

object SeqToDataFrame
{
  def fromSeqExample(spark: SparkSession): DataFrame =
  {
    val columns = Seq("name", "age", "nrOfChildren")
    val seqWithNan = Seq(("Anna", null , NaN))
    spark.createDataFrame(seqWithNan).toDF(columns: _*)
  }
}

object FillAndReplace
{
  def main(args: Array[String]): Unit = {
    replaceUnwantedValues(fromJson(spark, "src/main/resources/input2.json")).show()
//    replaceUnwantedValues(fromCsv(spark, "src/main/resources/input2.csv")).show()
    replaceUnwantedValues(fromSeqExample(spark)).show()
  }

  def replaceUnwantedValues(df: DataFrame): DataFrame =
  {
    var res = df.na.fill(Map("nrOfChildren" -> -1))
    res = res.na.fill(0) // replaces NaN, does not replace null
    res.na.replace(Array("name"), Map("Anna" -> "Ania"))
  }

////  Does not work as expected.
//  def replacing(df: DataFrame): Unit =
//  {
//    df.na.fill(Map("nrOfChildren" -> -1))
//    df.na.fill(0)
//    df.na.replace(Array("name"), Map("Anna" -> "Ania"))
//    df.show()
//  }
}