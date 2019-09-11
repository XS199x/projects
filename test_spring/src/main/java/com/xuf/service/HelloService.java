package com.xuf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author
 */
@Component(value="helloService")
public class HelloService {
	@Autowired
	private PersonService personService;
	
	public void sayHello(){
		System.out.println("hello"+personService.getName());
	}
}
