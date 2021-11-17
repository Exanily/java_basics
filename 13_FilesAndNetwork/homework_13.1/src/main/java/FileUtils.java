import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        long byte1 = 0;
        try (Stream<Path> paths = Files.walk(Paths.get(path))) {
            byte1 = paths
                    .filter(Files::isRegularFile).mapToLong(path1 -> path1.toFile().length()).sum();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byte1;
    }
}