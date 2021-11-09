package com.solvd.itcompany.threads;

public class ConnectionRun implements Runnable{


    private final String name;

    public ConnectionRun(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Runnable connection is created " + getName());
    }

    public String getName() {
        return name;
    }
}
