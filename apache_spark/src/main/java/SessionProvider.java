import org.apache.spark.sql.SparkSession;

public class SessionProvider
{
    public static SparkSession get()
    {
        return SparkSession.builder()
                .master("local")
                .appName("app name")
//                .config("a.b.c", "value")
                .getOrCreate();
    }
}
