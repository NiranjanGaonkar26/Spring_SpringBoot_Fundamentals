package com.example5.beans;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

//@Component
public class Vehicle {
    private String name;

//    @PostConstruct
//    public void init(){
//        this.setName("Fortuner");
//    }

    public Vehicle() {
        System.out.println("Vehicle Bean Created...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                '}';
    }
}
