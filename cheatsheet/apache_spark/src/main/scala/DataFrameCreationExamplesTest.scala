import ApacheSparkCheatsheet.{createSparkSession, sparkSqlStatementExample}
import FileToDataFrame.fromJsonExample
import RddToDataFrame.{withColumnNamesSpecifiedExample, withNumbersAsAttributesExample, withSchemaExplicitlySpecifiedExample, withSchemaReflectivelyInferredExample}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}

import scala.Double.NaN

object DataFrameCreationExamplesTest {

  val spark: SparkSession = createSparkSession
  val tupleSeq: Seq[(String, Int, Int)] = Seq(("John", 20 , 0), ("Sara", 30, 10))
  val personSeq: Seq[Person] = tupleSeq.map(tuple => Person(tuple._1, tuple._2, tuple._3))
  val rddFromCsv: RDD[String] = spark.sparkContext.textFile("src/main/resources/input.csv")
  val seqWithNan = Seq(
    ("Michał", NaN , 1),
    ("Maria", 30, 2),
    ("Adrian", 99, NaN),
    ("Anna", 0,0))

  case class Person(name: String, salary: Int, nrOfChildren: Int)

  def main(args: Array[String]): Unit =
  {
    val df = withSchemaReflectivelyInferredExample(spark, personSeq)
    sparkSqlStatementExample(spark, df).show()

    withColumnNamesSpecifiedExample(spark, tupleSeq).show()
    withNumbersAsAttributesExample(spark, tupleSeq).show()
    withSchemaReflectivelyInferredExample(spark, personSeq).show()
    withSchemaExplicitlySpecifiedExample(spark).show()
    fromJsonExample(spark).show()
  }

  def dfSchema(df: DataFrame): Array[String] =
  {
    df.schema.names
  }
}
