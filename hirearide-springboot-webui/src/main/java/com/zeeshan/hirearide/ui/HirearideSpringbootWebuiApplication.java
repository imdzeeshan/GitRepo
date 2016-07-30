package com.zeeshan.hirearide.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;


@SpringBootApplication
public class HirearideSpringbootWebuiApplication extends SpringBootServletInitializer{

	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(HirearideSpringbootWebuiApplication.class);
	    }

	public static void main(String[] args) {
		SpringApplication.run(HirearideSpringbootWebuiApplication.class, args);
		
	}
	

}
