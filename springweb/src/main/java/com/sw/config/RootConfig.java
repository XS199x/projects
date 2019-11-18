package com.sw.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Title: RootConfig
 * Description: TODO
 *
 * @author xuf
 * @version V1.0
 * @date 2019-11-06
 */
@Configuration
@PropertySource("classpath:/")
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.sw"},
	excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
	})
public class RootConfig {
}
