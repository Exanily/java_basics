import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WorkerThread implements Runnable {
    private final int regionCode;
    private final PrintWriter writer;
    private final long start;

    public WorkerThread(int regionCode, long start) throws FileNotFoundException {
        this.regionCode = regionCode;
        writer = new PrintWriter("res/numbers" + regionCode + ".txt");
        this.start = start;
    }

    char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

    @Override
    public void run() {
        StringBuilder stringBuffer = new StringBuilder();
        for (int number = 1; number < 1000; number++) {
            for (char firstLetter : letters) {
                for (char secondLetter : letters) {
                    for (char thirdLetter : letters) {
                        stringBuffer
                                .append(firstLetter)
                                .append(padNumber(number, 3))
                                .append(secondLetter)
                                .append(thirdLetter)
                                .append(padNumber(regionCode, 2))
                                .append("\n");
                    }
                }
            }
        }
        writer.write(stringBuffer.toString());
        writer.flush();
        writer.close();
        System.out.println("Поток " + regionCode + " завершился - " + (System.currentTimeMillis() - start) + " ms");
    }

    private static StringBuilder padNumber(int number, int numberLength) {
        StringBuilder numberStr = new StringBuilder(Integer.toString(number));
        int padSize = numberLength - numberStr.length();

        for (int i = 0; i < padSize; i++) {
            numberStr.insert(0, "0");
        }

        return numberStr;
    }
}
