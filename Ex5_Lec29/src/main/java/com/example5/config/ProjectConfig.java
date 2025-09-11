package com.example5.config;

import com.example5.beans.Person;
import com.example5.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public Person person(){
        Person person = new Person();
        person.setName("Niranjan");
        person.setVehicle(vehicle());
        return person;
    }

    @Bean
    public Vehicle vehicle(){
        Vehicle veh = new Vehicle();
        veh.setName("Fortuner");
        return veh;
    }
}
