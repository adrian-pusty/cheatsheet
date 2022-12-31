import DataFrameCreationExamplesTest.spark
import FileToDataFrame.fromJson
import SeqToDataFrame.fromSeqExample
import org.apache.spark.sql.DataFrame

object FillAndReplaceExamples
{
  def main(args: Array[String]): Unit = {
    replaceUnwantedValues(fromJson(spark, "src/main/resources/input.json")).show()
    //    replaceUnwantedValues(fromCsv(spark, "src/main/resources/input.csv")).show()
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