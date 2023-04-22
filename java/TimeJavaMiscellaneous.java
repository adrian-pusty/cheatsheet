import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

class TimeJavaMiscellaneous
{
    public long daysDiff() throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date firstDate = sdf.parse("1992-05-04");
        Date secondDate = sdf.parse("1992-05-05");

        return TimeUnit.DAYS.convert((secondDate.getTime() - firstDate.getTime()), TimeUnit.MILLISECONDS);
    }

    public void createDateAndTimestampWithCurrentTime()
    {
        new Timestamp(System.currentTimeMillis());
        new Timestamp(new Date().getTime());

        new Date();
    }

    public LocalTime parseExample(String val)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm:ss");
        return LocalTime.parse(val, formatter);
    }
    
    public void duration()
    {
        long startTime = System.nanoTime();
        // some method invocation
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
    }
}
