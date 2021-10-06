package main.java.by.chuprys.itcompany.domain;

import java.math.BigDecimal;

public class Woker extends Employee {

    private BigDecimal salary;
    private boolean uniform;

    public Woker(String id, String firstName, boolean isWork, boolean uniform){
        super(id, firstName, isWork);
        this.uniform = uniform;
    }

    @Override
    public String toString(){
        return "Woker: " + getFirstName();
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
