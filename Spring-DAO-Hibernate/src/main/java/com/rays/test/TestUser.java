package com.rays.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserService;

@Component("test")
public class TestUser {

	@Autowired
	private UserService service;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUser test = context.getBean("test", TestUser.class);

//		test.testAdd();
//		test.testUpdate();
//		test.testDelete();
//		test.testFindById();
//		test.testFindByLogin();
//		test.testAuthenticate();
		test.testSearch();
	}

	public void testAdd() {

		UserDTO dto = new UserDTO();

		dto.setId(3);
		dto.setFirstName("Tanisha");
		dto.setLastName("Rambadia");
		dto.setLogin("tanisha@gmail.com");
		dto.setPassword("tanisha123");

		int id = service.add(dto);

		System.out.println("User added with ID: " + id);
	}
	
	public void testUpdate() {

		UserDTO dto = new UserDTO();

		dto.setId(1);
		dto.setFirstName("John");
		dto.setLastName("Doe");
		dto.setLogin("johndoe");
		dto.setPassword("pass123");

		int id = service.update(dto);

		System.out.println("User Updated with ID: " + id);
	}
	
	public void testDelete() {

		service.delete(2);

		System.out.println("User deleted Successfully ");
	}
	
	public void testFindById() {

		UserDTO dto = service.findById(1);

		if (dto != null) {
			System.out.println("User Found: " + dto.getFirstName() + " " + dto.getLastName());
		} else {
			System.out.println("User not found");
		}
	}
	
	public void testFindByLogin() {

		UserDTO dto = service.findByLogin("ayushi@1gmail.com");

		if (dto != null) {
			System.out.println("User Found: " + dto.getFirstName() + " " + dto.getLastName());
		} else {
			System.out.println("User not found");
		}
	}
	
	public void testAuthenticate() {

		UserDTO dto = service.authenticate("tanisha@gmail.com", "tanisha123");

		if (dto != null) {
			System.out.println("User Found: " + dto.getFirstName() + " " + dto.getLastName());
		} else {
			System.out.println("User not found");
		}
	}
	
	public void testSearch() {

		UserDTO dto = new UserDTO();
//		dto.setFirstName("John");

		List<UserDTO> list = service.search(dto,1,10);

		for (UserDTO user : list) {
			System.out.println("User ID: " + user.getId());
			System.out.println("First Name: " + user.getFirstName());
			System.out.println("Last Name: " + user.getLastName());
			System.out.println("Login: " + user.getLogin());
			System.out.println("Password: " + user.getPassword());
			System.out.println("---------------------------");
		}
	}
		
}