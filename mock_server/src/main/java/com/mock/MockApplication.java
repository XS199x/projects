package com.mock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.ScheduledExecutorService;

/**
 * @author
 */
@SpringBootApplication
@MapperScan(value="com.mock.dao")
public class MockApplication implements WebMvcConfigurer {
	
	public static void main(String[] args) {
		SpringApplication.run(MockApplication.class, args);
	}
	
}
