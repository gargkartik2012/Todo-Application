package org.springbootdemo.todoapp.repo;

import org.springbootdemo.todoapp.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepo extends JpaRepository<ToDo,Long> {
    List<ToDo> findByStatus(String status);
}
