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
    public BigDecimal getSalaryPerMonth() {
        return salaryPerMonth;
    }

    @Override
    public void setSalaryPerMonth(BigDecimal salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }

}
