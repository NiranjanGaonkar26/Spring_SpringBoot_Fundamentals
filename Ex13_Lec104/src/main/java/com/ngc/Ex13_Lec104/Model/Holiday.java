package com.ngc.Ex13_Lec104.Model;

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
