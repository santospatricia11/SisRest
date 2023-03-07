package com.sisrest;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.sisrest.configuration.AppProperties;

@EnableScheduling
@EnableBatchProcessing
@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class SisrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SisrestApplication.class, args);

	}

}
