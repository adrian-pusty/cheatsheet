package cheatsheet;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.StructType;

import java.util.Properties;

import static org.apache.spark.sql.functions.lit;

public class SparkRead
{
    public static Dataset<Row> fromParquet(SparkSession session, String path)
    {
        return session.read().parquet(path);
    }

    public static Dataset<Row> fromCsv(SparkSession session, String path, StructType schema) {
        return session.read()
                .option("columnNameOfCorruptRecord", "_corrupt_record")
                .option("header", "false")
                .option("delimiter", ",")
                .option("locale", "en-GB")
                .option("ignoreTrailingWhiteSpace", Boolean.TRUE)
                .csv(path)
                .withColumn("additional_column", lit("something"))
                .toDF();
    }

    public Dataset<Row> fromDatabase(SparkSession session,
                                     String sourceUrl,
                                     String sourceTable,
                                     String user,
                                     String password,
                                     String[] predicates) {

        Properties properties = readJdbcProperties(user, password);

        return session.read()
                .jdbc(sourceUrl, sourceTable, predicates, properties);
    }

    private Properties readJdbcProperties(String user, String password) {
        Properties properties = jdbcProperties(user, password);
        properties.put("fetchsize", "100");
        return properties;
    }

    private Properties jdbcProperties(String user, String password) {
        Properties properties = new Properties();
        properties.put("user", user);
        properties.put("password", password);
        properties.put("driver", "oracle.jdbc.OracleDriver");
        return properties;
    }
}