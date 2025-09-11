package com.example5.beans;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;

    @Autowired(required = false)
    private Vehicle vehicle;

    @PostConstruct
    public void init(){
        this.setName("Niranjan");
    }

    public Person() {
        System.out.println("Person Bean Created...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
