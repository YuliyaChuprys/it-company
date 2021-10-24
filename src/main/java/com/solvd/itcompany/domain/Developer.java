package com.solvd.itcompany.domain;

import java.math.BigDecimal;

public class Developer extends Specialist {

    private String language;
    private BigDecimal salaryPerMonth;

    public Developer(String id, String firstName, boolean isWork, BigDecimal salaryPerMonth) {
        super(id, firstName, isWork, "Developer department");
        this.salaryPerMonth = salaryPerMonth;
    }

    @Override
    public void sendWelcomeMessage() {
        System.out.println("Welcome to Developer department!");
    }

    @Override
    public String toString() {
        return "Name: " + getFirstName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Developer developer = (Developer) o;

        if (language != null ? !language.equals(developer.language) : developer.language != null) return false;
        return salaryPerMonth != null ? salaryPerMonth.equals(developer.salaryPerMonth) : developer.salaryPerMonth == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (salaryPerMonth != null ? salaryPerMonth.hashCode() : 0);
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
