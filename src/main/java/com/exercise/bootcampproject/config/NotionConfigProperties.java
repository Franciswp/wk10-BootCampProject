package com.exercise.bootcampproject.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("java.runtime")
public record NotionConfigProperties(String apiVersion) {
}
