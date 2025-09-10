package com.example2.main;

import com.example2.beans.Vehicle;
import com.example2.config.ProjectConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example2 {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle veh = context.getBean(Vehicle.class);
        System.out.println("Vehicle Bean's name: "+veh.getName());
        veh.printHello();

    }
}
