package com.exercise.bootcampproject;

import com.exercise.bootcampproject.config.NotionConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(NotionConfigProperties.class)
public class BootCampProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootCampProjectApplication.class, args);
    }

}
