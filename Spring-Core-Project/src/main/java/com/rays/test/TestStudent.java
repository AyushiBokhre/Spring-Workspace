package com.rays.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestStudent {

	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("student.xml"));

		Student s = factory.getBean("student", Student.class);

		System.out.println(s.getName());
		System.out.println(s.getRollNo());
	}

}