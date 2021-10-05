package main.java.by.chuprys.itcompany.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProjectManager extends Employees {
    // private String level;
    private BigDecimal salaryPerMonth;

    public ProjectManager(LocalDate dateOfBirthday, boolean isWork, String id, BigDecimal salaryPerMonth) {
        super(dateOfBirthday, isWork, id);
        this.salaryPerMonth = salaryPerMonth;
    }

    @Override
    public void welcomMassage(){
        System.out.println(toString()+ "Поздравдяем с повышением, теперь ты менеджер!");
    }

    @Override
    public void departmentName(){
        System.out.println("Отдел Менеджеров: ");
    }

    public BigDecimal getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public void setSalaryPerMonth(BigDecimal salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }
}
