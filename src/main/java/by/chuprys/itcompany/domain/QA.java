package main.java.by.chuprys.itcompany.domain;

import java.math.BigDecimal;

public class QA extends Employee {
    //private String level;

    private BigDecimal salaryPerMonth;

    public QA(String id, String firstName, boolean isWork, BigDecimal salaryPerMonth) {
        super(id,  firstName, isWork);
        this.salaryPerMonth = salaryPerMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QA that = (QA) o;

        if (getId() != that.getId()) return false;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        int result = getFirstName() == null ? 0 : getFirstName().hashCode();
        result = 31 * result;
        return result;
    }

   public void sendWelcomeMassage(){
        System.out.println(toString() + "Welcome to Testing department");
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
