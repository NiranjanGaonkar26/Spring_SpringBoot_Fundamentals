package com.ngc.Ex16_Lec125.Model;

import lombok.Data;

@Data
public class Holiday {

    private final String day;
    private final String reason;
    private final Type type;

    public enum Type{
        FESTIVAL, FEDERAL
    }
}
