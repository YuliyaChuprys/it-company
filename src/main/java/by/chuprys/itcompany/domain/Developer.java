package main.java.by.chuprys.itcompany.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Developer extends Employees {

    //private String level;
    private String language;
    private BigDecimal salaryPerMonth;

    public Developer (LocalDate dateOfBirthday, boolean isWork, String id, BigDecimal salaryPerMonth) {
        super(dateOfBirthday, isWork, id);
        this.salaryPerMonth = salaryPerMonth;
    }

    //Employees stajor = new Developer(LocalDate.parse("2003-06-06"), false, null, null);

    public static void traineeship( Employees employees){
        employees.traineeship();
    }

    @Override
    public void welcomMassage() {
        System.out.println("Добро пожаловать в отдел разработки!");
    }

    @Override
    public void departmentName(){
        System.out.println("Отдел разработчиков: ");
    }

    @Override
    public String toString(){
        return "Имя: " + getFirstName() + ", Фамилия: " + getSecondName();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public BigDecimal getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public void setSalaryPerMonth(BigDecimal salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }

}
