package com.solvd.itcompany.domain;

public class Singleton {
    String firstName;
    String secondName;

    private static final Singleton DIRECTOR = new Singleton("Sandro","Botticelli");

    private Singleton(String firstName, String secondName){
        this.firstName = firstName;
        this.secondName = secondName;
    }


    public static Singleton getDirector(){
        return DIRECTOR;
    }

    @Override
    public String toString() {
        return "Director: " +
                "firstName: " + firstName +
                ", secondName: " + secondName;
    }
}
