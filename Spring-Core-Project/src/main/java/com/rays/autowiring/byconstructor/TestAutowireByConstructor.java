package com.rays.autowiring.byconstructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutowireByConstructor {
	public static void main(String[] args) {
		ApplicationContext context =new ClassPathXmlApplicationContext("autowiringbyconstructor.xml");
		Order o=context.getBean("order",Order.class);
		o.placedOrder(30);
	}

}
