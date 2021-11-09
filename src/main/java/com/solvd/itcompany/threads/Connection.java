package com.solvd.itcompany.threads;

public class Connection extends Thread {

    private static volatile Integer count = 2;
    private String field;

    public Connection(String name) {
        super(name);
    }

    public void connect() {
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Connection established.");
    }

    public void reed() {
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Reading data.");
    }

    public void update() {
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String field = this.field;
        System.out.println("Data was updated.");
    }

    public void delete() {
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Data was deleted.");
    }

    public static Integer getCount() {
        return count;
    }

    public String getField() {
        return field;
    }

    @Override
    public void run() {
        System.out.println("Started " + getName());

    }

}
