package com.zeeshan.hirearide.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * @author Muhammad Zeeshan
 * @category Main Class
 * @version 1.0.0
 * @since July 2016
 *
 */
@SpringBootApplication
public class HirearideSpringbootWebApplication extends SpringBootServletInitializer{

	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(HirearideSpringbootWebApplication.class);
	    }

	public static void main(String[] args) {
		SpringApplication.run(HirearideSpringbootWebApplication.class, args);
		
	}
	

}
