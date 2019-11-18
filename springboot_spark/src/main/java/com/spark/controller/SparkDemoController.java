package com.spark.controller;

import com.spark.service.SparkDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @**
 * @Description:
 * @Param:
 * @return:
 * @Author: xufan
 * @Date: 2019/11/13
 */
@RestController
public class SparkDemoController {
	
	@Autowired
	private SparkDemoService sparkDemoService;
	
	@RequestMapping("/demo/top10")
	public Map<String, Object> calculateTopTen() {
		return sparkDemoService.calculateTopTen();
	}
	
	@RequestMapping("/demo/exercise")
	public void exercise() {
		sparkDemoService.sparkExerciseDemo();
	}
	
	@RequestMapping("/demo/stream")
	public void streamingDemo() throws InterruptedException {
		sparkDemoService.sparkStreaming();
	}
}
