package com.zeeshan.hirearide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;


/**
 * @author Muhammad Zeeshan
 *
 * @version 1.0.0
 * @category Main Class
 * @since July 2016
 */
@SpringBootApplication
public class HirearideSpringbootApplication extends SpringBootServletInitializer{
	
	 
	@Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(HirearideSpringbootApplication.class);
	    }

	public static void main(String[] args) {
		SpringApplication.run(HirearideSpringbootApplication.class, args);
	
	}
}
