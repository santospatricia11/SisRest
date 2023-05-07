package com.sisrest;

import com.sisrest.configuration.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class SisrestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SisrestApplication.class, args);

    }

}
