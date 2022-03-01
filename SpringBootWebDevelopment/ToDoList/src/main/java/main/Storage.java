package main;

import response.ToDoList;

import java.util.ArrayList;
import java.util.HashMap;

public class Storage {
    private static int currentId = 1;
    private static final HashMap<Integer, ToDoList> toDoLists = new HashMap<>();

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
        if (toDoLists.containsKey(id)){
            return toDoLists.get(id);
        }
        return null;
    }
}
