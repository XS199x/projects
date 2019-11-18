package com.mock.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;


/**
 * @author
 */
@RestController
@RequestMapping(value = "/lyq")
public class HelloController {
	
	@GetMapping(value = "/hello")
	@Cacheable(value = "hello",keyGenerator="cacheKeyGenerator")
	public String hello(@RequestParam (value = "name") String name,@RequestParam (value = "sex",required = false) String sex){
		return "(GET)hello LYQ!!!"+name+"  性别："+sex;
	}
	
	@PostMapping(value = "/hello")
	@Cacheable(value = "hello2",key="#name")
	public String hello2(@RequestParam (value = "name") String name,@RequestParam (value = "sex",required = false) String sex){
		return "(POST)hello LYQ!!!"+name+"  性别："+sex;
	}
	
}
