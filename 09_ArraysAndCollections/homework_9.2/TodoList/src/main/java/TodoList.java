import java.util.ArrayList;

public class TodoList {
    private final ArrayList<String> arrayList = new ArrayList<>();
    private String todoTrim;

    public void add(String todo) {
        todoTrim = todo.trim();
        arrayList.add(todoTrim);
        printADD(todoTrim);
    }

    public void add(int index, String todo) {
        todoTrim = todo.trim();
        if (arrayList.size() > index) {
            arrayList.add(index, todoTrim);
            printADD(todoTrim);
        }
        if (arrayList.size() <= index) {
            add(todoTrim);
        }
    }

    public void edit(String todo, int index) {
        String old;
        if (arrayList.size() > index) {
            old = arrayList.get(index);
            arrayList.remove(index);
            arrayList.add(index, todo);
            System.out.println("Дело \"" + old + "\" заменено на \"" + todo + "\"");
        } else printError();
    }

    public void delete(int index) {
        if (arrayList.size() > index) {
            String remove = arrayList.get(index);
            arrayList.remove(index);
            System.out.println("Дело \"" + remove + "\" удалено");
        } else printError();
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел

        return arrayList;
    }

    private void printADD(String input) {
        System.out.println("Добавлено дело \"" + input + "\"");
    }

    private void printError() {
        System.out.println("Дело с таким номером не существует");
    }

}