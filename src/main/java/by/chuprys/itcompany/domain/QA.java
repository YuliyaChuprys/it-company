package main.java.by.chuprys.itcompany.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class QA extends Employees {
    //private String level;
    private BigDecimal salaryPerMonth;

    public QA(LocalDate dateOfBirthday, boolean isWork, String id,  BigDecimal salaryPerMonth){
        super(dateOfBirthday, isWork, id);
        //this.firstName = firstName;
        //this.secondName = secondName;
        this.salaryPerMonth = salaryPerMonth;
    }

    public boolean equals(QA qas){
        return this.getId() == qas.getId();
    }

    @Override
    public void welcomMassage(){
        System.out.println(toString() + "Добро пожаловать в отдел тестирования");
    }

    @Override
    public String toString(){
        return "Имя: " + getFirstName() + ", Идентификационный номер: " + this.getId();
    }

    public void departmentName(){
        System.out.println("Отдел тестировщиков: ");
    }

    public BigDecimal getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public void setSalaryPerMonth(BigDecimal salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }
}
