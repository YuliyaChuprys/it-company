package main.java.by.chuprys.itcompany.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Developer {

    private String firstName;
    private String secondName;
    private String level;
    private String language;
    private BigDecimal salaryPerMonth;
    private LocalDateTime dateOfBirthday;

    public Developer(String firstName, String secondName, String language, BigDecimal salaryPerMonth) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.language = language;
        this.salaryPerMonth = salaryPerMonth;
    }

    public Developer(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public BigDecimal getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public void setSalaryPerMonth(BigDecimal salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }

    public LocalDateTime getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDateTime dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }
}
