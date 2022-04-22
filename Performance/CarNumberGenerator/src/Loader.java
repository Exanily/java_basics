import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Loader {
    private static final int REGION = 200;

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int regionCode = 1; regionCode < REGION; regionCode++) {
            Runnable worker = new WorkerThread(regionCode, start);
            executor.execute(worker);
        }
        executor.shutdown();

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }


}
