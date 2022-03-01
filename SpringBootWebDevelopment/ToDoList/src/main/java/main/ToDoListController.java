package main;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import response.ToDoList;

import java.util.List;

@RestController
public class ToDoListController {
    @GetMapping("/ToDo/")
    public List<ToDoList> list() {
        return Storage.getAllToDo();
    }

    @RequestMapping(value = "/Todo/", method = RequestMethod.POST)
    public int add(ToDoList list) {
        return Storage.addToDo(list);
    }

    @GetMapping("/Todo/{id}")
    public ResponseEntity get(@PathVariable int id) {
        ToDoList list = Storage.getToDo(id);
        if (list == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(list, HttpStatus.OK);
    }

}
