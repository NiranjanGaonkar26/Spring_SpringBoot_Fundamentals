package com.example6.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class VehicleServices {

    private Speaker speaker;
    private Tyre tyre;

    @Autowired
    public VehicleServices(Speaker speaker, Tyre tyre){
        System.out.println("VehicleServices bean created by Spring");
        this.speaker = speaker;
        this.tyre = tyre;
    }

    public void playMusic(){
        System.out.println(speaker.makeSound());
    }

    public void moveVehicle(){
        System.out.println(tyre.rotate());
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }
}
