package com.example3.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printHello(){
        System.out.println("Hello World");
    }

    @PostConstruct
    public void init(){
        System.out.println("This method will be executed by Spring when a bean of this class is created");
        this.setName("Bentley");
    }

    @PreDestroy
    public void destructYourself(){
        System.out.println("This method will be executed by Spring just before the bean of this class is destroyed");
    }

}
