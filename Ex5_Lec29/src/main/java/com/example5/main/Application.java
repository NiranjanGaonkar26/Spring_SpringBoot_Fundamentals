package com.example5.main;

import com.example5.beans.Person;
import com.example5.config.ProjectConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person = context.getBean(Person.class);
        System.out.println("Person Name from Spring Context: "+person.getName());
        System.out.println(person.getName()+" drives: "+person.getVehicle());
    }
}
