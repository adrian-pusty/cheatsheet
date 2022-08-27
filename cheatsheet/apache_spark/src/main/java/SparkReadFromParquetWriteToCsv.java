import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SparkReadFromParquetWriteToCsv {
    /**
     * name,age,sex
     * John,36,M
     * Mary,73,F
     * Tom,10,M
     * Kathy,23,F
     */
    private static final String INPUT_CSV = "src/main/resources/input.csv";
    private static final String INPUT_PARQUET = "src/main/resources/input.parquet";
    public static void main(String[] args) {
        SparkSession session = SparkSession
                .builder()
                .master("local")
                .appName("app name")
//                .config("a.b.c", "value")
                .getOrCreate();
        Dataset<Row> csvInput = session.read().csv(INPUT_CSV);
        csvInput.write().parquet(INPUT_PARQUET);
        Dataset<Row> parquetInput = session.read().parquet(INPUT_PARQUET);
        parquetInput.collectAsList().forEach(System.out::println);
    }
}
