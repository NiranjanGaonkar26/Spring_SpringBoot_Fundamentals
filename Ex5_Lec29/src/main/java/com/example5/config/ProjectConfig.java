package com.example5.config;

import com.example5.beans.Person;
import com.example5.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example5.beans")
public class ProjectConfig {

}
