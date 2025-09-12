package com.asmnt1.main;

import com.asmnt1.beans.Person;
import com.asmnt1.beans.Speaker;
import com.asmnt1.beans.Vehicle;
import com.asmnt1.beans.VehicleServices;
import com.asmnt1.config.ProjectConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person = context.getBean(Person.class);
        Vehicle vehicle = person.getVehicle();
        VehicleServices vehicleServices = vehicle.getVehicleService();

        String[] speakers = context.getBeanNamesForType(Speaker.class);

        System.out.println(person.getName()+" welcome to your "+vehicle.getCarName());
        vehicleServices.playMusic();
        vehicleServices.moveVehicle();
    }
}
