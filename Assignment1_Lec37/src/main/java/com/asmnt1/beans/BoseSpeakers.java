package com.asmnt1.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component()
@Primary
public class BoseSpeakers implements Speaker{
    @Override
    public String makeSound() {
        return "You are listing to music from Bose Speakers: Better Sound Through Research";
    }
}
