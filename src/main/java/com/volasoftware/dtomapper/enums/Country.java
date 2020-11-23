package com.volasoftware.dtomapper.enums;

public enum Country {
    BULGARIA("Bulgaria"),
    THE_NORTH("The North"),
    USA("United States of America");

    private final String name;

    Country(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}