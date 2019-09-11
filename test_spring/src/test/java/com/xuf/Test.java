package com.xuf;

import com.xuf.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonService obj = (PersonService)applicationContext.getBean("personService");
		obj.sayHello();
	}
}
