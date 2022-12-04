
package com.todoapp.toDoApplication.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapp.toDoApplication.repository.ToDoRepository;

import com.todoapp.toDoApplication.entity.ToDo;

@Service
public class ToDoService {
	
	@Autowired
    private ToDoRepository toDoRepository;
	
	private final Logger logger = LoggerFactory.getLogger(ToDoService.class);
	
	// POST method to save ToDo

		public ToDo saveToDo(ToDo toDo) {
			logger.info(toDo.toString());
			return toDoRepository.save(toDo);
		}

		public List<ToDo> saveToDoList(List<ToDo> toDoList) {
			logger.info("Saved successfully");
			return toDoRepository.saveAll(toDoList);
		}

		// GET method to retieve ToDo

		public List<ToDo> getToDOList() {
			return toDoRepository.findAll();
		}

		public ToDo getToDoById(int id) {
			return toDoRepository.findById(id).orElse(null);

		}

		public ToDo getToDoByName(String name) {
			return toDoRepository.findByName(name);

		}
		
		public List<ToDo> getToDoByStatusAndUsername(String status, String username) {
			return toDoRepository.findAllByStatusAndUsername(status, username);

		}

		public List<ToDo> getToDoForUser(String username) {
			return toDoRepository.findAllByUsername(username);
		}

		// PUT to update ToDo

		public ToDo updateToDo(ToDo toDo) {
			ToDo existingToDo = toDoRepository.findById(toDo.getId()).orElse(null);
			existingToDo.setName(toDo.getName());
			existingToDo.setDescription(toDo.getDescription());
			existingToDo.setStatus(toDo.getStatus());
			existingToDo.setLastUpdatedDate(toDo.getLastUpdatedDate());
			return toDoRepository.save(existingToDo);
		}

		// DELETE to delete ToDo
		public String deleteToDo(int id) {
			toDoRepository.deleteById(id);
			return id + " id -> course deleted";
		}


}
