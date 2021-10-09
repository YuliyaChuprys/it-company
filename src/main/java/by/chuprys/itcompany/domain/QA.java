package main.java.by.chuprys.itcompany.domain;

import java.math.BigDecimal;

public class QA extends Employee {

    private BigDecimal salaryPerMonth;

    public QA(String id, String firstName, boolean isWork, BigDecimal salaryPerMonth) {
        super(id,  firstName, isWork);
        this.salaryPerMonth = salaryPerMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (! super.equals(o)) return false;
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;

        QA other = (QA) o;

        if (this.getSalaryPerMonth() != null) {
            return getSalaryPerMonth().equals(other.getSalaryPerMonth());
        } else {
            if (other.getSalaryPerMonth() != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = getFirstName() == null ? 0 : getFirstName().hashCode();
        result = 31 * result;
        return result;
    }

    @Override
    public String toString(){
        return "Name: " + getFirstName() + ", Identical ID: " + this.getId();
    }

    public void getDepartmentName(){
        System.out.println("Testing department: ");
    }

    public BigDecimal getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public void setSalaryPerMonth(BigDecimal salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }

}
