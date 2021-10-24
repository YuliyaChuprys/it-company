package com.solvd.itcompany.domain;

import java.math.BigDecimal;

public class ProjectManager<PM extends ProjectManager<?, ?, ?>, LD extends LeadDevelop<?, ?, ?>,
        LQ extends LeadQa<?, ?, ?>> extends Manager<PM, LD, LQ> {

    private BigDecimal salaryPerMonth;

    public ProjectManager(String id, String firstName, boolean work, String departmentName,
                          BigDecimal salaryPerMonth) {
        super(id, firstName, work, departmentName);
        this.salaryPerMonth = salaryPerMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ProjectManager<?, ?, ?> that = (ProjectManager<?, ?, ?>) o;

        return salaryPerMonth != null ? salaryPerMonth.equals(that.salaryPerMonth) : that.salaryPerMonth == null;
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
