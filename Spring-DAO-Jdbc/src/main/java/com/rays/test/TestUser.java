package com.rays.test;

import java.util.Iterator;
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

		// test.testAdd();
//		test.testUpdate();
//		test.testDelete();
//		test.testFindByPk();
//		test.testFindByLogin();
//		test.testAuthenticate();
		test.testSearch();

	}

	public void testAdd() {

		UserDTO dto = new UserDTO();
//		dto.setId(2);
		dto.setFirstName("Tanisha");
		dto.setLastName("Rambadia");
		dto.setLogin("tanisha@gmail.com");
		dto.setPassword("tanisha@123");

		service.add(dto);

	}

	public void testUpdate() {

		UserDTO dto = new UserDTO();
		dto.setId(2);
		dto.setFirstName("Tanisha");
		dto.setLastName("Rambadia");
		dto.setLogin("tanisha@gmail.com");
		dto.setPassword("tanisha@456");

		service.update(dto);
	}

	public void testDelete() {

		service.delete(2);

	}
	
	public void testFindByPk() {
		UserDTO dto = service.findByPk(1);
		System.out.println("ID: "+ dto.getId());
		System.out.println("First Name: "+dto.getFirstName());
		System.out.println("Last_Name: "+dto.getLastName());
		System.out.println("Login: "+dto.getLogin());
		System.out.println("Password: "+dto.getPassword());
	}
	
	public void testFindByLogin() {
		UserDTO dto = service.findByLogin("ayushi@gmail.com");
		System.out.println("ID: "+ dto.getId());
		System.out.println("First Name: "+dto.getFirstName());
		System.out.println("Last_Name: "+dto.getLastName());
		System.out.println("Login: "+dto.getLogin());
		System.out.println("Password: "+dto.getPassword());
	}
	
	public void testAuthenticate() {
		UserDTO dto = service.authenticate("ayushi@gmail.com", "ayushi123");
		System.out.println("ID: "+ dto.getId());
		System.out.println("First Name: "+dto.getFirstName());
		System.out.println("Last_Name: "+dto.getLastName());
		System.out.println("Login: "+dto.getLogin());
		System.out.println("Password: "+dto.getPassword());
	}
	
	public void testSearch() {
		UserDTO dto = new UserDTO();
//		dto.setFirstName("Tanisha");
		List<UserDTO> list=service.search(dto, 1, 10);
		Iterator<UserDTO> it=list.iterator();
		while(it.hasNext()) {
			UserDTO user=it.next();
			System.out.println("ID: "+ user.getId());
			System.out.println("First Name: "+user.getFirstName());
			System.out.println("Last Name: "+user.getLastName());
			System.out.println("Login: "+user.getLogin());
			System.out.println("Password: "+user.getPassword());
		}
		
	}
	
}