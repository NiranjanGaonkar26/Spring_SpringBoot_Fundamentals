package com.example7.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Order(1)
public class VehicleStartAspect {

    private Logger logger = Logger.getLogger(VehicleStartAspect.class.getName());

    @Before("execution(* com.example7.services.*.*(..)) && args(started,..)")
    public void checkVehicleStart(JoinPoint joinPoint, boolean started) throws Throwable{
        if(!started){
            throw new RuntimeException("Vehicle Not Started");
        }
    }
}
