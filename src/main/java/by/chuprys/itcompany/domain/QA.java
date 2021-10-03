package main.java.by.chuprys.itcompany.domain;

import java.math.BigDecimal;

public class QA {

    private String firstName;
    private String secondName;
    private String level;
    private BigDecimal salaryPerMonth;

    public QA(String firstName, String secondName, String level, BigDecimal salaryPerMonth){

        this.firstName = firstName;
        this.secondName = secondName;
        this.level = level;
        this.salaryPerMonth = salaryPerMonth;

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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public BigDecimal getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public void setSalaryPerMonth(BigDecimal salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }
}
