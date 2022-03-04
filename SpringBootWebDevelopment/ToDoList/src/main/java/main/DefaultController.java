package main;

import main.model.ToDoList;
import main.model.ToDoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;


@Controller
public class DefaultController {
    private final ToDoRepository repository;

    public DefaultController(ToDoRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/")
    public String index(Model model) {
        Iterable<ToDoList> iterable = repository.findAll();
        ArrayList<ToDoList> toDoList = new ArrayList<>();

        for (ToDoList list : iterable) {
            toDoList.add(list);
        }

        model.addAttribute("books", toDoList)
                .addAttribute("booksCount", toDoList.size());
        return "index";
    }
}
