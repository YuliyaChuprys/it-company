package main.java.by.chuprys.itcompany;

import main.java.by.chuprys.itcompany.domain.Customer;
import main.java.by.chuprys.itcompany.domain.DegreeOfEmployee;
import main.java.by.chuprys.itcompany.domain.Developer;
import main.java.by.chuprys.itcompany.domain.Project;
import main.java.by.chuprys.itcompany.domain.ProjectManager;
import main.java.by.chuprys.itcompany.domain.ProjectOffer;
import main.java.by.chuprys.itcompany.domain.QA;
import main.java.by.chuprys.itcompany.domain.Requirement;
import main.java.by.chuprys.itcompany.domain.Team;
import main.java.by.chuprys.itcompany.service.ProjectEstimationService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ITCompany {

    public static void main(String[] args) {
        Customer customer = new Customer("Grape", "+375291112233", "BigBoss",
                "email@mail.ru");
        Requirement requirement = new Requirement(8, "Создание нового проекта",
                LocalDate.parse("2022-10-01"));
        Project project = new Project("NewProject", requirement, customer);
        Developer fifthDev = new Developer(LocalDate.parse("2000-05-05"), true, "d04",
                new BigDecimal(500));
        fifthDev.welcomMassage();
        fifthDev.departmentName();
        fifthDev.setFirstName("Рафаэль");

        System.out.println(fifthDev.toString());

        QA thirdQa = new QA(LocalDate.parse("1990-02-01"), true, "t03", new BigDecimal(300));
        QA fourthQa = new QA(LocalDate.parse("1990-02-01"), true, "t03", new BigDecimal(300));
        thirdQa.setFirstName("Деонис");
        fourthQa.setFirstName("Давид");

        Team team = initializeData();
        ProjectEstimationService projectEstimationService = new ProjectEstimationService(); //объявление объекта
        ProjectOffer projectOffer = projectEstimationService.estimateProject(project, team, 2F);
                                     //DegreeOfEmployee degreeOfEmployee = new DegreeOfEmployee(); //объект "уровень работника"
                                     // DegreeOfEmployee degreeOfEmployee1 = degreeOfEmployee.getlevelEmployee();
        System.out.println("Стоимость проекта($) =" + projectOffer.getPrice() + ", Время выполнения(месяцев) =" +
                projectOffer.getExecutionTime() + ", " + projectOffer.getTeam().getTeamInfo());
        thirdQa.departmentName();
        System.out.println(thirdQa.toString());
        System.out.println(fourthQa.toString());
        System.out.println("Тестировщик 3 и тестировщик 4 - это один и тот же работник? " + thirdQa.equals(fourthQa));//equals
    }

    public static Team initializeData() {
        Developer[] developers = new Developer[3];
        QA[] qas = new QA[2];
        Developer firstDev = new Developer(LocalDate.parse("1994-12-31"), true, "d01",
                new BigDecimal(700));
        firstDev.setFirstName("Леонардо");
        Developer secondDev = new Developer(LocalDate.parse("1990-10-01"), true, "d02",
                new BigDecimal(1000));
        secondDev.setFirstName("Микеланджело");
        Developer fourthDev = new Developer(LocalDate.parse("1985-01-01"), true, "d03",
                new BigDecimal(2000));
        fourthDev.setFirstName("Донателло");

        developers[0] = firstDev;
        developers[1] = secondDev;
        developers[2] = fourthDev;

        System.out.println(firstDev.toString());
        System.out.println(secondDev.toString());
        System.out.println(fourthDev.toString());

        QA firstQa = new QA(LocalDate.parse("1994-02-13"), true, "t01", new BigDecimal(700));
        QA secondQa = new QA(LocalDate.parse("1990-02-02"), true, "t02", new BigDecimal(1000));

        qas[0] = firstQa;
        qas[1] = secondQa;

        ProjectManager firstManager = new ProjectManager(LocalDate.parse("1980-03-03"), true, "m01",
                new BigDecimal(3000));
        firstManager.setFirstName("Пётр");
        firstManager.setSecondName("Мамонов");

        LocalDateTime projectEnd = LocalDateTime.of(2021, 12, 15, 18, 00);
        return new Team(60, developers, qas, firstManager, projectEnd);
    }
}
