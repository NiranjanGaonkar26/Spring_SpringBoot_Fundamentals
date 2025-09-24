package com.example7.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.example7.implementation", "com.example7.services", "com.example7.aspects"})
public class ProjectConfig {
}
