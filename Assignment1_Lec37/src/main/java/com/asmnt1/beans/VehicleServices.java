package com.asmnt1.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleServices {

    private Speaker speaker;
    private Tyre tyre;

    @Autowired
    public VehicleServices(Speaker speaker, Tyre tyre){
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
