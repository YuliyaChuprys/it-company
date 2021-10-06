package main.java.by.chuprys.itcompany.domain;

import java.time.LocalDate;

public class Employee {

    private String id; //ID card
    private String firstName;
    private String secondName;
    private boolean isWork;
    private String passportData;
    private LocalDate dateOfBirthday;

    public Employee(String id, String firstName, boolean isWork){

        this.id = id;
        this.firstName = firstName;
        this.isWork = isWork;
    }

    public void sendWelcomMassage(){
        System.out.println("Welcome to Best Company!");
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public boolean isWork() {
        return isWork;
    }

    public void setWork(boolean work) {
        isWork = work;
    }

    public String getPassportData() {
        return passportData;
    }

    public void setPassportData(String passportData) {
        this.passportData = passportData;
    }

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDate dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }
}

