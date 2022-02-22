import java.io.*;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;


public class Main {

    private static final String URL = "https://skillbox.ru";
    private static final String PATH = "out/file.txt";

    public static void main(String[] args) throws IOException {
        ForkJoinPool pool = new ForkJoinPool();
        Processor processor = new Processor(URL);
        pool.execute(processor);
        do {
            System.out.print("******************************************\n");
            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
            System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
            System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
            System.out.print("******************************************\n");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!processor.isDone());

        pool.shutdown();

        Map<String, Map> list = processor.join();
        createFile();
        FileWriter fileWriter = new FileWriter(PATH);
        save(list, fileWriter, -1);
        fileWriter.close();
    }

    private static void save(Map<String, Map> map, FileWriter fileWriter, int counter) throws IOException {

        int c = counter;
        c++;
        Set<String> strings = map.keySet();
        List<String> list = strings.stream().toList();
        for (int i = 0; i < map.values().size(); i++) {
            fileWriter.write(string(c) + "" + list.get(i) + "\n");
            save(map.get(list.get(i)), fileWriter, c);
        }
    }

    private static String string(int t) {
        return "\t".repeat(Math.max(0, t));
    }

    private static void createFile() throws IOException {
        File directory = new File("out");
        File file = new File(directory + "\\file.txt");
        if (directory.mkdir()) {
            System.out.println("Директория \"out\" создана");
        }
        if (file.createNewFile()) {
            System.out.println("Файл \"file.txt\" создан");
        }
    }
}
