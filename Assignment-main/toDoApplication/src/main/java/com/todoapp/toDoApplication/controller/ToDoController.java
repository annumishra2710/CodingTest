package com.todoapp.toDoApplication.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todoapp.toDoApplication.service.ToDoService;
import com.todoapp.toDoApplication.entity.ToDo;


@CrossOrigin
@RestController
public class ToDoController {
	
	@Autowired 
	ToDoService toDoService;
	
	private final Logger logger = LoggerFactory.getLogger(ToDoController.class);
	
	@PostMapping("/addToDo")
	public ToDo addToDo(@RequestBody ToDo toDo) {
		logger.info("ToDo Object {}", toDo.toString());
		return toDoService.saveToDo(toDo);
	}

	@PostMapping("/addToDoList")
	public List<ToDo> addToDoList(@RequestBody List<ToDo> toDoList) {
		logger.info("Saving the ToDo List started");
		return toDoService.saveToDoList(toDoList);
	}

	@GetMapping("/getAllToDoList")
	public List<ToDo> getAllToDoList() {
		logger.info("Retrieving All ToDo List started");
		return toDoService.getToDOList();
	}

	@GetMapping("/findToDoById/{id}")
	public ToDo findToDoById(@PathVariable int id) {
		logger.info("Retrieving ToDo by Id started");
		return toDoService.getToDoById(id);
	}

	@GetMapping("/findToDoByName/{name}")
	public ToDo findToDoByName(@PathVariable String name) {
		logger.info("Retrieving ToDo by Name started");
		return toDoService.getToDoByName(name);
	}

	@GetMapping("/findToDoByUsername/{username}")
	public List<ToDo> findToDoByUsername(@PathVariable String username) {
		logger.info("Retrieving ToDo by Username started");
		return toDoService.getToDoForUser(username);
	}
	
	@GetMapping("/findToDoByStatusUsername/{status}/{username}")
	public List<ToDo> findToDoByStatusAndUsername(@PathVariable String status , @PathVariable String username) {
		logger.info("Retrieving ToDo by Status And Username started");
		return toDoService.getToDoByStatusAndUsername(status, username);
	}

	@PutMapping("/updatetoDo")
	public ToDo updatetoDo(@RequestBody ToDo toDo) {
		logger.info("Updating ToDo started");
		return toDoService.updateToDo(toDo);
	}

	@DeleteMapping("/deleteToDoById/{id}")
	public String deleteToDoById(@PathVariable int id) {
		logger.info("Deleting ToDo by Id started");
		return toDoService.deleteToDo(id);
	}

}
