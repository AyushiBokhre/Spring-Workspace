package com.rays.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyBean {
	public static void main(String[] args) {
		
	ApplicationContext context =new ClassPathXmlApplicationContext("mybean.xml");
	MyBean bean=context.getBean("mybean",MyBean.class);
	System.out.println("------------------");
	((ClassPathXmlApplicationContext) context).close();
	
	}

}
