import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

object ApacheSparkCheatsheet {
  case class Person(name: String, age: Int, sex: String)

  def main(args: Array[String]): Unit = {}

  private def createSparkSession = {
    SparkSession
      .builder()
      .master("local[1]")
      .appName("app name")
      //    .config("a.b.c", "value")
      .getOrCreate()
  }

  private def withColumnNamesSpecified(spark: SparkSession) = {
    val sequence: Seq[(String, Int, String)] = Seq(("John", 20 , "M"), ("Sara", 30, "F"))
    val rdd = spark.sparkContext.parallelize(sequence)

    import spark.implicits._
    rdd.toDF("name", "age", "sex")  // does not compile (Cannot resolve symbol toDF) if 'import spark.implicits._' is commented out // https://stackoverflow.com/a/47185056/15493760
  }

  private def withNumbersAsAttributes(spark: SparkSession): DataFrame = {
    val sequence: Seq[(String, Int, String)] = Seq(("John", 20 , "M"), ("Sara", 30, "F"))
    val rdd = spark.sparkContext.parallelize(sequence)

    import spark.implicits._
    rdd.toDF
  }

  private def withSchemaReflectivelyInferred(spark: SparkSession) = {
    val rdd = spark.sparkContext.parallelize(Seq(
      Person("John", 20 , "M"),
      Person("Sara", 30, "F")))

    import spark.implicits._
    rdd.toDF
  }

  private def withSchemaExplicitlySpecified(spark: SparkSession) = {
    val rdd = spark.sparkContext.textFile("src/main/resources/input.csv")

    val schemaString = "NAME AGE SEX"
    val fields = schemaString
      .split(" ")
      .map(fieldName => StructField(fieldName, StringType, nullable = true))
    val schema = StructType(fields)

    val rowRDD = rdd
      .map(_.split(","))
      .map(attributes => Row(attributes(0).trim, attributes(1), attributes(2)))
    spark.createDataFrame(rowRDD, schema)
  }

  /**
   * Note that JSON file must contain properly formatted lines.
   * Array of elements in json is not allowed and each element must take a single line to avoid AnalysisException.
   * See also: https://stackoverflow.com/a/38895521/15493760
   */
  private def fromJson(spark: SparkSession) = {
    val path = "src/main/resources/input.json"
    spark.read.json(path)
  }

  private def dfSchema(df: DataFrame) = {
    df.schema.names
  }

  def sampleSparkSqlStatement(spark: SparkSession, peopleDF: DataFrame): DataFrame =
  {
    peopleDF.createOrReplaceTempView("people")
    spark.sql("SELECT * FROM people WHERE age < 25")
  }
}