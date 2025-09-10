package com.ex1.main;

import com.ex1.beans.Vehicle;
import com.ex1.config.ProjectConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example1 {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        Vehicle veh1Bean = context.getBean("Vehicle_Creta", Vehicle.class);
        System.out.println("Vehicle Bean's Name: "+veh1Bean.getName());

        Vehicle veh2Bean = context.getBean("Vehicle_XUV500", Vehicle.class);
        System.out.println("Vehicle Bean's Name: "+veh2Bean.getName());

        Vehicle veh3Bean = context.getBean("Vehicle_Thar", Vehicle.class);
        System.out.println("Vehicle Bean's Name: "+veh3Bean.getName());

        String strBean = context.getBean(String.class);
        System.out.println("Printing the primary String Bean: "+strBean);
    }
}
