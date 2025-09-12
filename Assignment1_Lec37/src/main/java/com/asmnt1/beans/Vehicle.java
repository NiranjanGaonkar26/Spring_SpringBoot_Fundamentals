package com.asmnt1.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("vehicleBean")
public class Vehicle {

    private String carName;
    private VehicleServices vehicleService;

    @Autowired
    public Vehicle(VehicleServices vehicleService){
        System.out.println("Vehicle bean created ...");
        this.vehicleService = vehicleService;
        this.carName = "Rolls Royce";
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public VehicleServices getVehicleService() {
        return vehicleService;
    }

    public void setVehicleService(VehicleServices vehicleService) {
        this.vehicleService = vehicleService;
    }
}
