package com.spark.config;

import org.apache.spark.SparkConf;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spark")
public class SparkContextBean {

	private String sparkHome = ".";
	
	private String appName = "sparkTest";
	
	private String master = "local";
	
	@Bean
	@ConditionalOnMissingBean(SparkConf.class)
	public SparkConf sparkConf() throws Exception{
		SparkConf conf = new SparkConf().setAppName(appName).setMaster(master);
		return conf;
	}
	
	

}
