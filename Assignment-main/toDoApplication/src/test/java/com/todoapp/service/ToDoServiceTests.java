package com.todoapp.service;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.todoapp.toDoApplication.entity.ToDo;
import com.todoapp.toDoApplication.repository.ToDoRepository;

@SpringBootTest
@ActiveProfiles("test")
public class ToDoServiceTests {

	@Mock
	private ToDoRepository toDoRepositoryTest;

	Date createdDate = null;

	Date lastUpdatedDate = null;

	ToDo toDoTestObject1 = new ToDo(1, "TestName", "TestDescription", "TestStatus", "TestUserName", createdDate,
			lastUpdatedDate);
	ToDo toDoTestObject2 = new ToDo(1, "TestName", "TestDescription", "TestStatus", "TestUserName", createdDate,
			lastUpdatedDate);

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void saveToDoTest() {
		Mockito.when(toDoRepositoryTest.save(Mockito.any())).thenReturn(toDoTestObject1);
	}

	@Test
	public void saveToDoListTest() {
		Mockito.when(toDoRepositoryTest.saveAll(Mockito.any()))
				.thenReturn(Arrays.asList(toDoTestObject1, toDoTestObject2));
	}

	@Test
	public void getToDOListTest() {
		Mockito.when(toDoRepositoryTest.findAll()).thenReturn(Arrays.asList(toDoTestObject1, toDoTestObject2));
	}

	@Test
	public void getToDoByIdTest() {
		Mockito.when(toDoRepositoryTest.findById(Mockito.anyInt())).thenReturn(Optional.of(toDoTestObject1));
	}

	@Test
	public void getToDoByNameTest() {
		Mockito.when(toDoRepositoryTest.findByName(Mockito.any())).thenReturn(toDoTestObject1);
	}

	@Test
	public void getToDoByStatusAndUsernameTest() {
		Mockito.when(toDoRepositoryTest.findAllByStatusAndUsername(Mockito.any(), Mockito.any()))
				.thenReturn(Arrays.asList(toDoTestObject1, toDoTestObject2));
	}

	@Test
	public void getToDoForUserTest() {
		Mockito.when(toDoRepositoryTest.findAllByUsername(Mockito.any()))
				.thenReturn(Arrays.asList(toDoTestObject1, toDoTestObject2));
	}

	@Test
	public void updateToDoTest() {
		Mockito.when(toDoRepositoryTest.findById(Mockito.anyInt())).thenReturn(Optional.of(toDoTestObject1));
		Mockito.when(toDoRepositoryTest.save(Mockito.any())).thenReturn(toDoTestObject1);
	}

	@Test
	public void deleteToDoTest() {

		Mockito.doNothing().when(toDoRepositoryTest).deleteById(Mockito.anyInt());
	}

}
