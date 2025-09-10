package com.example3.main;

import com.example3.beans.Vehicle;
import com.example3.config.ProjectConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle veh = context.getBean(Vehicle.class);

        System.out.println("Vehicle bean's name from the spring context: "+veh.getName());
        veh.printHello();

        context.close();
    }
}
