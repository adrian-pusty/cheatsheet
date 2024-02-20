import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SparkReadFromParquetWriteToCsv
{
    /**
     * name,age,sex
     * John,36,M
     * Mary,73,F
     * Tom,10,M
     * Kathy,23,F
     */
    private static final String INPUT_CSV = "src/main/resources/input.csv";
    private static final String INPUT_PARQUET = "src/main/resources/input.parquet";

    public static void main(String[] args)
    {
        SparkSession session = SessionProvider.get();

        Dataset<Row> csvInput = fromCsv(session, INPUT_CSV);
        toParquet(csvInput, INPUT_PARQUET);
        Dataset<Row> parquetInput = fromParquet(session, INPUT_PARQUET);

        parquetInput.collectAsList().forEach(System.out::println);
    }

    private static Dataset<Row> fromCsv(SparkSession session, String path)
    {
        return session.read().csv(path);
    }

    private static Dataset<Row> fromParquet(SparkSession session, String path)
    {
        return session.read().parquet(path);
    }

    private static void toParquet(Dataset<Row> df, String path)
    {
        df.write().parquet(path);
    }
}
