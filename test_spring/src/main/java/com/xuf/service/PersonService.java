package com.xuf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author
 */
@Component(value="personService")
public class PersonService {
	
	@Autowired
	private HelloService helloService;
	
	@Value("张三")
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void sayHello(){
		helloService.sayHello();
	}
}
