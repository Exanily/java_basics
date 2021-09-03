public class Printer {
    String queue = "";
    int totalPages = 0;
    int totalPendingPagesCount = 0;

    public void append(String text) {
        append(text, "", 0);
    }

    public void append(String text, String name) {
        append(text, name, 0);
    }

    public void append(String text, String name, int numberOfPages) {

        if (contains(text)) {
            return;
        }
        queue = queue + text + " - " + name + " - " + numberOfPages + "\n";
        totalPages = totalPages + numberOfPages;
        totalPendingPagesCount = totalPendingPagesCount + numberOfPages;
    }

    public boolean contains(String name) {
        return queue.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (queue.isEmpty()) {
            System.out.println("Очередь пуста");
        } else {
            System.out.println(queue);
        }
        System.out.println("Страниц в очереди: " + getPendingPagesCount());
        System.out.println("Страницы напечатаны");
        clear();
        totalPendingPagesCount = 0;
    }

    public void clear() {
        queue = "";
        System.out.println("Очередь очищена");
    }

    public int getPendingPagesCount() {
        return totalPendingPagesCount;
    }

    public int getTotalPages() {
        return totalPages;
    }

}
