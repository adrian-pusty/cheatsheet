class BigDecimalScaleAndPrecision
{
    BigDecimal withPrecision = new BigDecimal("12345.6789").round(new MathContext(3, RoundingMode.HALF_UP)); // 1.23E+4 - three significant digits
    BigDecimal withScale = new BigDecimal("12345.6789").setScale(3, RoundingMode.HALF_UP); // 12345.679 - three digits to the right of the decimal point
}

public class Java
{
    @Test
    public void miscellaneous()
    {
        str.substring(str.length() - 1); // Print last character from string. String str = "Hello world" -> "d"

        Stream<Path> pathStream = Files.find(Path.of("/some/path"), 10, (Path p, BasicFileAttributes bfa) -> p.toString().endsWith(".txt")); // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Files.html#find(java.nio.file.Path,int,java.util.function.BiPredicate,java.nio.file.FileVisitOption...)

        (int) (Math.log10(n)+1); // Number of digits in n
    }
    
    public static int randomInteger(int min, int max)
    {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public void miscellaneous_strings() {
        {
            String lines[] = string.split("\\r?\\n"); // Split String by new line
        }
        {
            import org.apache.commons.lang.StringUtils;
            if (StringUtils.isNotBlank(str)) {
            } // https://stackoverflow.com/questions/3598770/check-whether-a-string-is-not-null-and-not-empty
        }
        {
            // Add leading zeroes to number in Java //https://stackoverflow.com/questions/275711/add-leading-zeroes-to-number-in-java
            // 0 - to pad with zeros
            // 3 - to set width to 3
            String.format("%03d", num);
        }
    }

    public void time()
    {
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm:ss");
            LocalTime t = LocalTime.parse(times.get(i), formatter);
        }
    }
    
    /**
     * "\n" - to consume whole line, it would split on whitespace without useDelimiter("\n")
     * @see "Scanner.java -> \p{javaWhitespace}"
     */
    public static List<String> readLines1(String pathToFile) throws FileNotFoundException
    {
        List<String> lines = new ArrayList<>();
        
        try(Scanner s = new Scanner(new File(pathToFile)).useDelimiter("\n"))
        {
            while(s.hasNext())
            {
                lines.add(s.next());
            }
        }
        return lines;
    }

    private static List<String> readLines2(String pathToFile) throws IOException
    {
        List<String> lines = new ArrayList<>();

        InputStream is = new FileInputStream(pathToFile);
        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);

        for (String line; (line = br.readLine()) != null; )
        {
            lines.add(line);
        }
        return lines;
    }
}

class Dates
{
    @Test
    public void dateDiff()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date firstDate = sdf.parse("1992-05-04");
        Date secondDate = sdf.parse("1992-05-05");

        TimeUnit.DAYS.convert((secondDate.getTime() - firstDate.getTime()), TimeUnit.MILLISECONDS);
    }

    @Test
    public void createDateAndTimestampWithCurrentTime()
    {
        new Timestamp(System.currentTimeMillis());
        new Timestamp(new Date().getTime());

        new Date();
    }
}

class AssertThrowsJunit5
{
    public void doThing() throws Exception {
        throw new Exception("Stuff");
    }

    @Test
    void exceptionTesting() {
        final AssertThrowsJunit5 myObject = new AssertThrowsJunit5();

        final Exception thrown = assertThrows(
                Exception.class,
                myObject::doThing,
                "Expected doThing() to throw, but it didn't" //org.opentest4j.AssertionFailedError: Expected doThing() to throw, but it didn't ==> Expected java.lang.Exception to be thrown, but nothing was thrown.
        );

        assertTrue(thrown.getMessage().contains("Stuff"));
    }

    @Test
    void floatingPointComparisons()
    {
        Assertions.assertEquals(0, Float.compare(1f, 1.0f));
        Assertions.assertEquals(-1, Double.compare(2.3, 3.1));
    }
}

@Entity
class SampleEntityWithId
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
