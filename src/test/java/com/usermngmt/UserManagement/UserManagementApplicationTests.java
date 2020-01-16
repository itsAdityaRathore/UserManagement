package com.usermngmt.UserManagement;

import com.usermngmt.UserManagement.Model.User;
import com.usermngmt.UserManagement.Repository.UserRepository;
import com.usermngmt.UserManagement.Service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class UserManagementApplicationTests {

	@Autowired
	UserService userService;

	@MockBean
	UserRepository userRepository;

	@Test
	void findAllTest() {
		when(userRepository.findAll()).thenReturn(Stream.of(
				new User("Aditya", "Salim@gmail.com", "Udaipur", "9090909090", "AM", ""),
				new User("Mohan", "Mohan@yahoo.in", "Ajmer", "9090901234", "SM", "1001"),
				new User("Amit", "Amit@gmail.com", "Kolkata", "9093456090", "SM", "1001"))
				.collect(Collectors.toList()));
		assertEquals(3, userService.findAllUsers().size());
	}

	@Test
	void bulkCreateTest() {
		List<User> usersBulk;
		usersBulk = Arrays.asList(
				new User("Aditya", "Salim@gmail.com", "Udaipur", "9090909090", "AM", ""),
				new User("Mohan", "Mohan@yahoo.in", "Ajmer", "9090901234", "SM", "1001"),
				new User("Amit", "Amit@gmail.com", "Kolkata", "9093456090", "SM", "1001"),
				new User("Rahul", "Rahul@outlook.com", "Raipur", "9879609090", "LP", "1002"),
				new User("Salim", "Salim@gmail.com", "Bikaner", "8841909090", "AM", ""),
				new User("Parul", "Parul@yahoo.in", "Chennai", "7896909090", "SM", "1005"),
				new User("Gaurav", "Gaurav@gmail.com", "Himachal", "9980789090", "LP", "1006"),
				new User("Avish", "Avish@outlook.com", "Goa", "8890656090", "LP", "1006")
		);
		when(userRepository.saveAll(usersBulk)).thenReturn(usersBulk);  //here use repository methods
		assertEquals("Bulk Creation Completed", userService.bulkcreate());  //here use service methods
	}

	@Test
	void createUserTest() {
		User newUser = new User("Aditya", "Salim@gmail.com", "Udaipur", "9090909090", "AM", "");
		when(userRepository.save(newUser)).thenReturn(newUser);
		assertEquals("User is created", userService.createUser(newUser));
	}

	@Test
	void searchUserByIdTest() {
		Optional<User> user = Optional.of(new User("Aditya", "Salim@gmail.com", "Udaipur", "9090909090", "AM", ""));
		when(userRepository.findById(1001l)).thenReturn(user);
		assertEquals(user, userService.searchUserById(1001l));
		System.out.println(user);
	}

	@Test
	void searchByUmanagerTest() {
		List<User> users = Arrays.asList(
				new User("Mohan", "Mohan@yahoo.in", "Ajmer", "9090901234", "SM", "1001"),
				new User("Amit", "Amit@gmail.com", "Kolkata", "9093456090", "SM", "1001")
		);
		when(userRepository.findByUmanager("1001")).thenReturn(users);
		assertEquals(users, userService.searchByManager("1001"));
	}

	@Test
	void searchByUroleAndUmanagerTest() {
		List<User> users = Arrays.asList(
				new User("Mohan", "Mohan@yahoo.in", "Ajmer", "9090901234", "SM", "1001"),
				new User("Amit", "Amit@gmail.com", "Kolkata", "9093456090", "SM", "1001")
		);
		when(userRepository.findByUroleAndUmanager("SM", "1001")).thenReturn(users);
		assertEquals(users, userService.searchByUroleAndUmanager("SM", "1001"));
	}

	@Test
	void deleteUserTest() {
		userService.deleteUser(1001l);
		verify(userRepository, times(1)).deleteById(1001l);
	}

}
