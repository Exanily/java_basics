import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        try {
            File sourceDir = new File(sourceDirectory);
            File destDir = new File(destinationDirectory);
            Path destPath = destDir.toPath();
            Path sourcePath = sourceDir.toPath();
            try (Stream<Path> paths = Files.walk(Paths.get(sourceDirectory))) {
                paths.forEach(path -> {
                    System.out.println(destPath.resolve(sourcePath.relativize(path)));
                    Path dest = destPath.resolve(sourcePath.relativize(path));
                    if (Files.exists(dest)) {
                        try {
                            Files.delete(dest);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        Files.copy(path, dest);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
