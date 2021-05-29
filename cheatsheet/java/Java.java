public class Java
{
    public static void main(String[] args) {
        str.substring(str.length() - 1); // Print last character from string. String str = "Hello world" -> "d"

        Stream<Path> pathStream = Files.find(Path.of("/some/path"), 10, (Path p, BasicFileAttributes bfa) -> p.toString().endsWith(".txt")); // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Files.html#find(java.nio.file.Path,int,java.util.function.BiPredicate,java.nio.file.FileVisitOption...)
    }
}