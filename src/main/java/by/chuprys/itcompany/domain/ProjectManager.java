package main.java.by.chuprys.itcompany.domain;

import java.math.BigDecimal;

public class ProjectManager extends Manager {
    // private String level;
    private BigDecimal salaryPerMonth;

    public ProjectManager(String id, String firstName, boolean isWork, String departmentName,
                          BigDecimal salaryPerMonth) {
        super(id, firstName, isWork, departmentName);
        this.salaryPerMonth = salaryPerMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ProjectManager that = (ProjectManager) o;

        return salaryPerMonth.equals(that.salaryPerMonth);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + salaryPerMonth.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ProjectManager{" +
                "salaryPerMonth=" + salaryPerMonth +
                '}';
    }

    @Override
    public BigDecimal getSalaryPerMonth() {
        return salaryPerMonth;
    }

    @Override
    public void setSalaryPerMonth(BigDecimal salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }

}
