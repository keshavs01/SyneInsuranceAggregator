package com.synechron.insurancecompany.webconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.synechron.insurancecompany.entity.Policy;

@Service
public class WebConfig {

	@Bean
	public Policy policy() {
		return new Policy();
	}
//	
//	/**
//	 * 
//	 * CODE FOR GLOBAL CROSS ORIGIN SETTINGS
//	 * 
//	 * **/
//	
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("api/v1/policy").allowedOrigins("http://localhost:2020");
//			}
//		};
//	}
}
