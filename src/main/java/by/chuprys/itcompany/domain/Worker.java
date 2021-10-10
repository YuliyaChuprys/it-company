package main.java.by.chuprys.itcompany.domain;

import java.math.BigDecimal;

public class Worker extends Employee {

    private BigDecimal salary;
    private boolean uniform;

    public Worker(String id, String firstName, boolean isWork, boolean uniform) {
        super(id, firstName, isWork);

        this.uniform = uniform;
    }

    @Override
    public String toString() {
        return "Worker: " + getFirstName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Worker worker = (Worker) o;

        return uniform == worker.uniform;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (uniform ? 1 : 0);
        return result;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public boolean isUniform() {
        return uniform;
    }

    public void setUniform(boolean uniform) {
        this.uniform = uniform;
    }
}
