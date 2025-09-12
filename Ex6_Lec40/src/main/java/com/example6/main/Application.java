package com.example6.main;

import com.example6.beans.Person;
import com.example6.beans.Speaker;
import com.example6.beans.Vehicle;
import com.example6.beans.VehicleServices;
import com.example6.config.ProjectConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        VehicleServices vs1 = context.getBean(VehicleServices.class);
        VehicleServices vs2 = context.getBean("vehicleServices", VehicleServices.class);

        System.out.println("Hash Code of the vs1 bean is: "+vs1.hashCode());
        System.out.println("Hash Code of the vs2 bean is: "+vs2.hashCode());

        if(vs1 == vs2) {
            System.out.println("Only one instance of the VehicleServices bean is maintained, and the same will be referenced every time");
        }

//        System.out.println("This line will be printed before the Person bean creation");
//        Person person = context.getBean(Person.class);
//        System.out.println("This line will always be printed after the Person bean creation");
    }
}
