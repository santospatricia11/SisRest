package com.sisrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.sisrest.configuration.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class SisrestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SisrestApplication.class, args);

    }

}
