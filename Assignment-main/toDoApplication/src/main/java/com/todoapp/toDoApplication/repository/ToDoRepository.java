package com.todoapp.toDoApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoapp.toDoApplication.entity.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
	ToDo findByName(String name);
	List<ToDo> findAllByStatusAndUsername(String status, String username);
	List<ToDo> findAllByUsername(String username);

}
