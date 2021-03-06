package com.xuf;

import com.xuf.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;


public class Test {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mvc.xml");
		Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach((s)-> System.out.println(s));
		PersonService obj = (PersonService)applicationContext.getBean("personService");
		obj.sayHello();
	}
}
