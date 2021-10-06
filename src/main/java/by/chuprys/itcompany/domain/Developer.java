package main.java.by.chuprys.itcompany.domain;

import java.math.BigDecimal;

public class Developer extends Employee {

    //private String level;
    private String language;
    private BigDecimal salaryPerMonth;

    public Developer (String id, String firstName, boolean isWork, BigDecimal salaryPerMonth) {
        super(id,  firstName, isWork);
        this.salaryPerMonth = salaryPerMonth;
    }

   public void devWelcomMassage() {
        System.out.println("Welcome to Developer department!");
    }

    @Override
    public String toString(){
        return "Name: " + getFirstName();
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

}
