package main;

import main.model.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.model.ToDoList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ToDoListController {

    @Autowired
    private ToDoRepository repository;

    @GetMapping("/todo/")
    public List<ToDoList> list() {
        Iterable<ToDoList> iterable = repository.findAll();
        ArrayList<ToDoList> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<ToDoList> get(@PathVariable int id) {
        Optional<ToDoList> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(optional.get(), HttpStatus.OK);
    }

    @PostMapping("/todo/")
    public int add(ToDoList list) {
        ToDoList toDoList = repository.save(list);
        return toDoList.getId();
    }

    @PutMapping("/todo/{id}")
    public ResponseEntity<ToDoList> put(@PathVariable int id, ToDoList list) {
        Optional<ToDoList> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        ToDoList toDoList = optional.get();
        toDoList.setName(list.getName());
        repository.save(toDoList);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/todo/")
    public String deleteAll() {
        repository.deleteAll();
        return "Все дела удалены";
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<ToDoList> deleteId(@PathVariable int id) {
        Optional<ToDoList> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        repository.deleteById(id);
        return new ResponseEntity<>(optional.get(), HttpStatus.OK);
    }
}
