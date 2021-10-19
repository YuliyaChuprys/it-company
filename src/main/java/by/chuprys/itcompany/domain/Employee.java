package by.chuprys.itcompany.domain;

import by.chuprys.itcompany.exeption.InvalidWorkExperienceMonth;

import java.time.LocalDate;

public class Employee {

    private String id;
    private String firstName;
    private String secondName;
    private boolean work;
    private String passportData;
    private LocalDate dateOfBirthday;
    private int workExperienceMonth;
    private String rating;

    public Employee(String id, String firstName, boolean work) {
        this.id = id;
        this.firstName = firstName;
        this.work = work;
    }

    public void sendWelcomeMessage() {
        System.out.println("Welcome to Best Company!");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", work=" + work +
                ", passportData='" + passportData + '\'' +
                ", dateOfBirthday=" + dateOfBirthday +
                ", workExperienceMonth=" + workExperienceMonth +
                ", rating='" + rating + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (work != employee.work) return false;
        if (workExperienceMonth != employee.workExperienceMonth) return false;
        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (secondName != null ? !secondName.equals(employee.secondName) : employee.secondName != null) return false;
        if (passportData != null ? !passportData.equals(employee.passportData) : employee.passportData != null)
            return false;
        if (dateOfBirthday != null ? !dateOfBirthday.equals(employee.dateOfBirthday) : employee.dateOfBirthday != null)
            return false;
        return rating != null ? rating.equals(employee.rating) : employee.rating == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (work ? 1 : 0);
        result = 31 * result + (passportData != null ? passportData.hashCode() : 0);
        result = 31 * result + (dateOfBirthday != null ? dateOfBirthday.hashCode() : 0);
        result = 31 * result + workExperienceMonth;
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
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
        return work;
    }

    public void setWork(boolean work) {
        this.work = work;
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

    public void setWorkExperienceMonth(int workExperienceMonth) throws InvalidWorkExperienceMonth {

        if (workExperienceMonth < 0) {
            throw new InvalidWorkExperienceMonth("Incorrect value of workOfExperience is entered");
        }
        this.workExperienceMonth = workExperienceMonth;
    }
}



