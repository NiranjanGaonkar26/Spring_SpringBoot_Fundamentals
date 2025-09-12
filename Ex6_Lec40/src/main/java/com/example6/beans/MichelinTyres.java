package com.example6.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MichelinTyres implements Tyre{
    @Override
    public String rotate() {
        return "Moving with Michelin tyres: On the road and beyond!";
    }
}
