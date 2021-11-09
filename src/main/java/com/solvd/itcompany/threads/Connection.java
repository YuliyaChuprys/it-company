package com.solvd.itcompany.threads;

public class Connection {
    private int index;


    public Connection(int index) {
        this.index = index;
    }

    public void connect() {
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Connection established. Tread = " + Thread.currentThread().getName() + ". Connection index= " + index);
    }

    public void reed() {
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Reading data."  + Thread.currentThread().getName() + ". Connection index= " + index);
    }

    public void update() {
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Data was updated."  + Thread.currentThread().getName() + ". Connection index= " + index);
    }

    public void delete() {
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Data was deleted."  + Thread.currentThread().getName() + ". Connection index= " + index);
    }

}
