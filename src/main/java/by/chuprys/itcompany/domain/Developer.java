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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Developer developer = (Developer) o;

        return language.equals(developer.language);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + language.hashCode();
        return result;
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
