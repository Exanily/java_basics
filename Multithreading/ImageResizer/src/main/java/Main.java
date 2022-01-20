import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;

public class Main {
    private static final int NEW_WIDTH = 300;

    public static void main(String[] args) {
        String srcFolder = "";
        String dstFolder = "";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        int middle = files.length / 4;

        File[] files1 = new File[middle];
        System.arraycopy(files, 0, files1, 0, files1.length);
        ImageResizer resizer = new ImageResizer(files1, dstFolder, NEW_WIDTH, start);
        new Thread(resizer).start();

        File[] files2 = new File[middle];
        System.arraycopy(files, middle, files2, 0, files2.length);
        ImageResizer resizer2 = new ImageResizer(files2, dstFolder, NEW_WIDTH, start);
        new Thread(resizer2).start();

        File[] files3 = new File[middle];
        System.arraycopy(files, 2 * middle, files3, 0, files3.length);
        ImageResizer resizer3 = new ImageResizer(files3, dstFolder, NEW_WIDTH, start);
        new Thread(resizer3).start();

        File[] files4 = new File[middle];
        System.arraycopy(files, 3 * middle, files4, 0, files4.length);
        ImageResizer resizer4 = new ImageResizer(files4, dstFolder, NEW_WIDTH, start);
        new Thread(resizer4).start();

    }

}
