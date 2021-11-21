import org.apache.spark.sql.SparkSession

object SparkCheatsheet {
  def main(args: Array[String]): Unit = {
    // Create spark session
    val spark = SparkSession
      .builder()
      .master("local[1]")
      .appName("cheatsheet")
      //    .config("a.b.c", "value")
      .getOrCreate()
  }
}