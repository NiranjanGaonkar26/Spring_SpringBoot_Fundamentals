package com.example7.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example7.implementation", "com.example7.services"})
public class ProjectConfig {
}
