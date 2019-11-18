package com.xuf.service;

import com.xuf.utils.FileUtil;
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
		
//		FileUtil.pdf2png("C:\\Users\\xufan\\Desktop","Python3简明教程(中文版)","png");
	}
}
