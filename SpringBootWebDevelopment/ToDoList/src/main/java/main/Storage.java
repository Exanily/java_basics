package main;

import response.ToDoList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Storage {
    private static int currentId = 1;
    private static ConcurrentHashMap<Integer, ToDoList> toDoLists = new ConcurrentHashMap<>();

    public static int addToDo(ToDoList list) {
        int id = currentId++;
        list.setId(id);
        toDoLists.put(id, list);
        return id;
    }

    public static ArrayList<ToDoList> getAllToDo() {
        return new ArrayList<>(toDoLists.values());
    }

    public static ToDoList getToDo(int id) {
        if (toDoLists.containsKey(id)) {
            return toDoLists.get(id);
        }
        return null;
    }

    public static void deleteAll() {
        toDoLists = new ConcurrentHashMap<>();
    }

    public static Integer delete(int id) {
        if (toDoLists.containsKey(id)) {
            toDoLists.remove(id);
            return id;
        }
        return null;
    }

    public static List<Integer> putAll(ArrayList<ToDoList> lists) {
        ArrayList<Integer> ids = new ArrayList<>();
        lists.forEach(list -> {
            int id = list.getId();
            if (toDoLists.containsKey(id)) {

                toDoLists.replace(id, list);
                ids.add(id);
            }
        });
        return ids;
    }

    public static Integer put(int id, ToDoList list) {
        if (toDoLists.containsKey(id)) {
            toDoLists.replace(id, list);
            return id;
        }
        return null;
    }
}
