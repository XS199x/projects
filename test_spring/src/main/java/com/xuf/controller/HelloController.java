package com.xuf.controller;

import com.xuf.aop.LogAspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String printHello() {
		return "hello";
	}
	
	@RequestMapping("/helloMvc")
	public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
		ModelAndView mav = new ModelAndView("index.jsp");
		mav.addObject("message", "Hello Spring MVC");
		return mav;
	}
}
