package main;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import response.ToDoList;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ToDoListController {
    @GetMapping("/todo/")
    public List<ToDoList> list() {
        return Storage.getAllToDo();
    }

    @PostMapping("/todo/")
    public int add(ToDoList list) {
        return Storage.addToDo(list);
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity get(@PathVariable int id) {
        ToDoList list = Storage.getToDo(id);
        if (list == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @DeleteMapping("/todo/")
    public String deleteAll() {
        Storage.deleteAll();
        return "Все дела удалены";
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity deleteId(@PathVariable int id) {
        Integer integer = Storage.delete(id);
        if (integer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(integer, HttpStatus.OK);
    }

    @PutMapping("/todo/{id}")
    public ResponseEntity put(@PathVariable int id, ToDoList list) {
        Integer integer = Storage.put(id, list);
        if (integer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(integer, HttpStatus.OK);
    }

}
