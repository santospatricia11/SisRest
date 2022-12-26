package com.sisrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SisrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SisrestApplication.class, args);
	}

//	@Bean
//	 public WebMvcConfigurer configure() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry reg) {
//				reg.addMapping("/**").allowedOrigins("*");
//			}
//	  };
//	}

}
