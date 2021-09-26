import java.util.ArrayList;

public class TodoList {
    private final ArrayList<String> arrayList = new ArrayList<>();

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        arrayList.add(todo.trim());
        System.out.println("Добавлено дело \"" + todo.trim() + "\"");
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if (arrayList.size() > index) {
            arrayList.add(index, todo.trim());
            System.out.println("Добавлено дело \"" + todo.trim() + "\"");
        }
        if (arrayList.size() <= index) {
            arrayList.add(todo.trim());
            System.out.println("Добавлено дело \"" + todo.trim() + "\"");
        }
    }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        String old;
        if (arrayList.size() > index) {
            old = arrayList.get(index);
            arrayList.remove(index);
            arrayList.add(index, todo);
            System.out.println("Дело \"" + old + "\" заменено на \"" + todo + "\"");
        } else System.out.println("Дело с таким номером не существует");
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (arrayList.size() > index) {
            String remove = arrayList.get(index);
            arrayList.remove(index);
            System.out.println("Дело \"" + remove + "\" удалено");
        } else System.out.println("Дело с таким номером не существует");
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел

        return arrayList;
    }

}