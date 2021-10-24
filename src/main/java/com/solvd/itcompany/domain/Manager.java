package com.solvd.itcompany.domain;

import java.math.BigDecimal;
import java.util.List;

public class Manager<PM, LD, LQ>
        extends Employee implements Educable {

    private String departmentName;
    private float salaryBonus;
    private BigDecimal salaryPerMonth;
    private List<PM> projectManager;
    private List<LD> leadDeveloper;
    private List<LQ> leadQa;

    public Manager(String id, String firstName, boolean work, String departmentName) {
        super(id, firstName, work);
        this.departmentName = departmentName;
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

    @Override
    public String toString() {
        return "Manager: " + getFirstName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Manager<?, ?, ?> manager = (Manager<?, ?, ?>) o;

        if (Float.compare(manager.salaryBonus, salaryBonus) != 0) return false;
        if (departmentName != null ? !departmentName.equals(manager.departmentName) : manager.departmentName != null)
            return false;
        if (salaryPerMonth != null ? !salaryPerMonth.equals(manager.salaryPerMonth) : manager.salaryPerMonth != null)
            return false;
        if (projectManager != null ? !projectManager.equals(manager.projectManager) : manager.projectManager != null)
            return false;
        if (leadDeveloper != null ? !leadDeveloper.equals(manager.leadDeveloper) : manager.leadDeveloper != null)
            return false;
        return leadQa != null ? leadQa.equals(manager.leadQa) : manager.leadQa == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + departmentName.hashCode();
        return result;
    }

    public List<PM> getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(List<PM> projectManager) {
        this.projectManager = projectManager;
    }

    public List<LD> getLeadDeveloper() {
        return leadDeveloper;
    }

    public void setLeadDeveloper(List<LD> leadDeveloper) {
        this.leadDeveloper = leadDeveloper;
    }

    public List<LQ> getLeadQa() {
        return leadQa;
    }

    public void setLeadQa(List<LQ> leadQa) {
        this.leadQa = leadQa;
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
