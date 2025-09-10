package com.example4.main;

import com.example4.beans.Vehicle;
import com.example4.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Application {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Random random = new Random();
        int randomNumber = random.nextInt(10);

        Supplier<Vehicle> audiSupplierLambda = () -> {
            Vehicle audi = new Vehicle();
            audi.setName("Audi Q7");
            return audi;
        };

        Supplier<Vehicle> bmwSupplierLambda = () -> {
            Vehicle bmw = new Vehicle();
            bmw.setName("BMW e5");
            return bmw;
        };

        System.out.println("Random Number Generated: "+randomNumber);
        if (randomNumber%2 == 0){
            context.registerBean("Audi", Vehicle.class, audiSupplierLambda);
        }
        else{
            context.registerBean("BMW", Vehicle.class, bmwSupplierLambda);
        }

        Vehicle audiVeh = null;
        Vehicle bmwVeh = null;

        try{
            audiVeh = context.getBean("Audi", Vehicle.class);
        }
        catch (NoSuchBeanDefinitionException e){
            System.out.println(""+e);
        }

        try{
            bmwVeh = context.getBean("BMW", Vehicle.class);
        }
        catch (NoSuchBeanDefinitionException e){
            System.out.println(""+e);
        }

        if(audiVeh != null){
            System.out.println("Name of the Audi Vehicle: "+audiVeh.getName());
        }
        else{
            System.out.println("Name of the BMW Vehicle: "+bmwVeh.getName());
        }

    }
}
