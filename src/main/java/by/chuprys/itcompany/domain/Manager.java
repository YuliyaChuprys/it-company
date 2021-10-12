package main.java.by.chuprys.itcompany.domain;

import java.math.BigDecimal;

public class Manager extends Employee implements Educable {

    private String departmentName;
    private float salaryBonus;
    private BigDecimal salaryPerMonth;

    public Manager(String id, String firstName, boolean isWork, String departmentName) {
        super(id, firstName, isWork);
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Manager: " + getFirstName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Manager manager = (Manager) o;

        return departmentName.equals(manager.departmentName);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + departmentName.hashCode();
        return result;
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

    @Override
    public void educate(String level) {
        System.out.println("Education in progress ");
        super.setRating(level);
    }

    @Override
    public String getLevel() {
        return super.getRating();
    }
}
