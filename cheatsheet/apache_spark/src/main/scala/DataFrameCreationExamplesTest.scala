import ApacheSparkCheatsheet.createSparkSession
import FileToDataFrame.fromJsonExample
import RddToDataFrame.{withColumnNamesSpecifiedExample, withNumbersAsAttributesExample, withSchemaExplicitlySpecifiedExample, withSchemaReflectivelyInferredExample}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}

import scala.Double.NaN

object DataFrameCreationExamplesTest {

  val spark: SparkSession = createSparkSession
  val tupleSeq: Seq[(String, Int, String)] = Seq(("John", 20 , "M"), ("Sara", 30, "F"))
  val personSeq: Seq[Person] = tupleSeq.map(tuple => Person(tuple._1, tuple._2, tuple._3))
  val rddFromCsv: RDD[String] = spark.sparkContext.textFile("src/main/resources/input.csv")
  //todo where is input from json?
  val seqWithNan = Seq(
    ("Michał", NaN , 1),
    ("Maria", 30, 2),
    ("Adrian", 99, NaN), //an expression of type Null is ineligible for implicit conversion
    ("Anna", 0,0))

  case class Person(name: String, age: Int, sex: String)

  def main(args: Array[String]): Unit =
  {
    val wcns = withColumnNamesSpecifiedExample(spark, tupleSeq)
    val wnaa = withNumbersAsAttributesExample(spark, tupleSeq)
    val wsri = withSchemaReflectivelyInferredExample(spark, personSeq)
    val wses = withSchemaExplicitlySpecifiedExample(spark)
    val fj = fromJsonExample(spark)

    //todo
  }

  def dfSchema(df: DataFrame): Array[String] =
  {
    df.schema.names
  }
}
