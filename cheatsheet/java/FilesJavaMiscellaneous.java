import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

class FilesJavaMiscellaneous
{
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

    public Stream<Path> findFilesWithTxtExtension() throws IOException
    {
        return findFilesWithExtension("/some/path",".txt");
    }

    public Stream<Path> findFilesWithExtension(String pathStr, String extension) throws IOException
    {
        // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Files.html#find(java.nio.file.Path,int,java.util.function.BiPredicate,java.nio.file.FileVisitOption...)
        Path path = Path.of(pathStr);
        BiPredicate<Path, BasicFileAttributes> hasExtension = (Path p, BasicFileAttributes bfa) -> p.toString().endsWith(extension);

        return Files.find(path, 10, hasExtension);
    }
}
