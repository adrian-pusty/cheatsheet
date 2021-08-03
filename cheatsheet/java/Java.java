public class Java
{
    public static void main(String[] args) {
        str.substring(str.length() - 1); // Print last character from string. String str = "Hello world" -> "d"

        Stream<Path> pathStream = Files.find(Path.of("/some/path"), 10, (Path p, BasicFileAttributes bfa) -> p.toString().endsWith(".txt")); // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Files.html#find(java.nio.file.Path,int,java.util.function.BiPredicate,java.nio.file.FileVisitOption...)
    }

    @Test
    public void dateDiff()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date firstDate = sdf.parse("1992-05-04");
        Date secondDate = sdf.parse("1992-05-05");

        TimeUnit.DAYS.convert((secondDate.getTime() - firstDate.getTime()), TimeUnit.MILLISECONDS);
    }
}

class AssertThrowsJunit5 {
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
}

