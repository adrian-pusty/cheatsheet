package cheatsheet;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;

import static cheatsheet.SparkJavaConfig.INPUT_CSV;
import static cheatsheet.SparkJavaConfig.INPUT_PARQUET;
import static cheatsheet.SparkJavaConfig.getSession;

public class SparkWrite
{
    public static void main(String[] args)
    {
        SparkSession session = getSession();

        Dataset<Row> csvInput = SparkRead.fromCsv(session, INPUT_CSV, null);
        toParquet(csvInput, INPUT_PARQUET);
        Dataset<Row> parquetInput = SparkRead.fromParquet(session, INPUT_PARQUET);

        parquetInput.collectAsList().forEach(System.out::println);
    }

    private static void toParquet(Dataset<Row> df, String path)
    {
        df.write().parquet(path);
    }

    public void toDatabase(Dataset<Row> dataset,
                           String targetUrl,
                           String targetTable,
                           String user,
                           String password)
    {
        dataset.write()
                .format("jdbc")
                .option("url", targetUrl)
                .option("dbtable", targetTable)
                .option("driver", "oracle.jdbc.OracleDriver")
                .option("user", user)
                .option("password", password)
                .option("batchsize", "100")
                .option("isolationLevel", "NONE")
                .mode(SaveMode.Append)
                .save();
    }
}
