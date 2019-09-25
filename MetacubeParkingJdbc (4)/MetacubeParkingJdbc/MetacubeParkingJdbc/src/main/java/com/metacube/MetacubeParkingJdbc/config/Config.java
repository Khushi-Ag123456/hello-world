package com.metacube.MetacubeParkingJdbc.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.metacube.MetacubeParkingJdbc.util.ValidationFilter;

@Configuration
public class Config {

	@Bean
	public FilterRegistrationBean<ValidationFilter> validationFilter(){
	    FilterRegistrationBean<ValidationFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	         
	    registrationBean.setFilter(new ValidationFilter());
	    registrationBean.addUrlPatterns("/home",
	    		"/friends",
	    		"/FileUpload",
	    		"/update",
	    		"/friendProfile"
	    		);
	         
	    return registrationBean;    
	}
}