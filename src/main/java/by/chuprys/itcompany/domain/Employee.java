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
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //проверяем равен ли он сам себе
        if (o == null || getClass() != o.getClass()) return false; //проверка Not null и принадлежит ли одному классу

        Employee that = (Employee) o;

        if (getFirstName() != that.getFirstName()) return false;
        return getFirstName().equals(that.getFirstName());
    }

    @Override
    public int hashCode() {
        int result = getId() == null ? 0 : hashCode();
        result = 31 * result;
        return result;
    }

    @Override
    public String toString(){
        return "Employee Name: " + getFirstName();
    }

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

