public class Spark
{
    public static void main(String[] args) {
        df.createOrReplaceTempView("cars"); // Register the DataFrame as a SQL temporary view
        var result = spark.sql("SELECT * FROM cars WHERE weight > 1100"); // todo - https://spark.apache.org/docs/0.9.1/api/core/index.html#org.apache.spark.package
    }
}