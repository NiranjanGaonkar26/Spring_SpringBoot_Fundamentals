package com.example6.beans;

import org.springframework.stereotype.Component;

@Component
public class SonySpeakers implements Speaker{
    @Override
    public String makeSound() {
        return "You are listing to music from Sony Speakers: FOR THE MUSIC";
    }
}
