package com.spark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @**
 * @Description:
 * @Param:
 * @return:
 * @Author: xufan
 * @Date: 2019/11/13
 */
@SpringBootApplication
@EnableCaching
public class SpringbootSparkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSparkApplication.class, args);
	}

}
