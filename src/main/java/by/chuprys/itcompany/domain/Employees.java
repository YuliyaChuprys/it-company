package main.java.by.chuprys.itcompany.domain;

import java.time.LocalDate;

public abstract class Employees {

    private String firstName;
    private String secondName;
    private LocalDate dateOfBirthday;
    private String placeOfBirth;
    private boolean isWork;
    private String id; //ID card

    public Employees(LocalDate dateOfBirthday, boolean isWork, String id){
        this.dateOfBirthday = dateOfBirthday;
        this.isWork = isWork;
        this.id = id;
    }

    public abstract void welcomMassage();

    public abstract void departmentName();

    public void traineeship(){
        System.out.println("Добро пожаловать на стажировку! ");
    }

    @Override
    public String toString(){
        return "Дата рождения" + dateOfBirthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public  String getSecondName(){
        return secondName;
    }

    public void setSecondName(String secondName){
        this.secondName = secondName;
    }

    public String getPlaceOfBirth(){
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth){
        this.placeOfBirth = placeOfBirth;
    }

    public boolean getIswork(){
        return isWork;
    }

    public void setIsWork(boolean isWork){
        this.isWork = isWork;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

