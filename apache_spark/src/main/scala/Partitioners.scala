import ApacheSparkCheatsheet.createSparkSession
import DataFrameCreationExamplesTest.Person
import org.apache.spark.HashPartitioner
import org.apache.spark.RangePartitioner
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object Partitioners {

  def main(args: Array[String]): Unit = {
    val session = createSparkSession
    createPartitioners(session)
  }

  /**
   * @see https://spark.apache.org/docs/latest/api/scala/org/apache/spark/RangePartitioner.html
   * @see https://spark.apache.org/docs/latest/api/scala/org/apache/spark/HashPartitioner.html
   */
  def createPartitioners(spark: SparkSession): Unit = {
    val rdd = spark.sparkContext.parallelize(Seq(Person("John", 20 , 0), Person("Sara", 30, 10)))
      .map(x =>(x.name,x)): RDD[(String, Person)] // RangePartitioner wouldn't compile without map at the end ("Type RangePartitioner takes type parameters")

    rdd.cache()

    val rp = new RangePartitioner(8, rdd) : RangePartitioner[String, Person] // or: new RangePartitioner(8, rdd, ascending = true)
    val hp = new HashPartitioner(8) : HashPartitioner
  }
}
