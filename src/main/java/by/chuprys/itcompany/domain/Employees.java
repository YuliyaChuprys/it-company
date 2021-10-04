package main.java.by.chuprys.itcompany.domain;

import java.time.LocalDateTime;

public class Employees {

    private String firstName;
    private String secondName;
    private String placeOfBirth;
    private boolean isWork;
    private LocalDateTime dateOfBirthday;

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

    public LocalDateTime getDateOfBirthday(){
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDateTime dateOfBirthday){
        this.dateOfBirthday = dateOfBirthday;
    }
}

