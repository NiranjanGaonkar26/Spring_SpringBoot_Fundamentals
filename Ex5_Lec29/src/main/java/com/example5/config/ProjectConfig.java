package com.example5.config;

import com.example5.beans.Person;
import com.example5.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "com.example5.beans")
public class ProjectConfig {

//    @Bean(name = "audiVehicleBean")
//    Vehicle vehicle1(){
//        Vehicle veh1 = new Vehicle();
//        veh1.setName("Audi");
//        return veh1;
//    }
//
//    @Bean(value = "bmwVehicleBean")
//    Vehicle vehicle2(){
//        Vehicle veh2 = new Vehicle();
//        veh2.setName("BMW");
//        return veh2;
//    }
//
//    @Bean("mercedesVehicleBean")
////    @Primary
//    Vehicle vehicle3(){
//        Vehicle veh3 = new Vehicle();
//        veh3.setName("Mercedes");
//        return veh3;
//    }
}
