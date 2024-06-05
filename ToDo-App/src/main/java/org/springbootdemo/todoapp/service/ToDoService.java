package org.springbootdemo.todoapp.service;

import org.springbootdemo.todoapp.repo.ToDoRepo;
import org.springbootdemo.todoapp.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    ToDoRepo repo;

    public List<ToDo> getAllToDoItems() {
        List<ToDo> todoList = new ArrayList<>(repo.findAll());
        return todoList;
    }

    public ToDo getToDoItemById(Long id) {
        Optional<ToDo> optionalTodo = repo.findById(id);
        return optionalTodo.orElse(null);
    }

    public boolean updateStatus(Long id) {
        ToDo todo = getToDoItemById(id);
        if (todo != null) {
            todo.setStatus("Completed");
            return saveOrUpdateToDoItem(todo);
        }
        return false;
    }

    public boolean saveOrUpdateToDoItem(ToDo todo) {
        ToDo updatedObj = repo.save(todo);
        return getToDoItemById(updatedObj.getId()) != null;
    }

    public boolean deleteToDoItem(Long id) {
        repo.deleteById(id);
        return repo.findById(id).isEmpty();
    }
}
