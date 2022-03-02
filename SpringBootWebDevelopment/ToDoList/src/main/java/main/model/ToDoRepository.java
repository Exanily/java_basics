package main.model;

import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDoList, Integer> {
}
