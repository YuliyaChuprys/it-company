package main.java.by.chuprys.itcompany.domain;

import java.time.LocalDate;

public class Employee {

    private String id;
    private String firstName;
    private String secondName;
    private boolean isWork;
    private String passportData;
    private LocalDate dateOfBirthday;
    private int workExperienceMonth;
    private String raiting;

    public Employee(String id, String firstName, boolean isWork){

        this.id = id;
        this.firstName = firstName;
        this.isWork = isWork;
    }

    public void sendWelcomMassage(){
        System.out.println("Welcome to Best Company!");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", isWork=" + isWork +
                ", passportData='" + passportData + '\'' +
                ", dateOfBirthday=" + dateOfBirthday +
                ", workExperienceMonth=" + workExperienceMonth +
                ", raiting='" + raiting + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee that = (Employee) o;

        if (getId() != that.getId()) return false;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        int result = getId() == null ? 0 : hashCode();
        result = 31 * result;
        return result;
    }



    public String getRaiting() {
        return raiting;
    }

    public void setRaiting(String raiting) {
        this.raiting = raiting;
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

    public int getWorkExperienceMonth() {
        return workExperienceMonth;
    }

    public void setWorkExperienceMonth(int workExperienceMonth) {
        this.workExperienceMonth = workExperienceMonth;
    }
}

