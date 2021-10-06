package main.java.by.chuprys.itcompany.domain;

import java.math.BigDecimal;

public class Manager extends Employee {

    private String departmentName;
    private float salaryBonus;
    private BigDecimal salaryPerMonth;

    public Manager(String id, String firstName, boolean isWork, String departmentName){
        super(id, firstName, isWork);
        this.departmentName = departmentName;
    }

    @Override
    public String toString(){
        return "Manager: " + getFirstName();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public float getSalaryBonus() {
        return salaryBonus;
    }

    public void setSalaryBonus(float salaryBonus) {
        this.salaryBonus = salaryBonus;
    }

    public BigDecimal getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public void setSalaryPerMonth(BigDecimal salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }
}
