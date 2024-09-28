package cheatsheet;

import org.apache.spark.sql.SparkSession;

public class SparkJavaConfig
{
    /**
     * name,age,sex
     * John,36,M
     * Mary,73,F
     * Tom,10,M
     * Kathy,23,F
     */
    public static final String INPUT_CSV = "src/main/resources/input.csv";
    public static final String INPUT_PARQUET = "src/main/resources/input.parquet";

    public static SparkSession getSession()
    {
        return SparkSession.builder()
                .master("local")
                .appName("cheatsheet")
//                .config("a.b.c", "value")
                .getOrCreate();
    }
}

