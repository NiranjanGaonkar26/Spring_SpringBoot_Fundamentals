package com.example6.beans;

import org.springframework.stereotype.Component;

@Component
public class BridgeStoneTyres implements Tyre{
    @Override
    public String rotate() {
        return "Moving with BridgeStone tyres: Solutions for your journey";
    }
}
