package main.java.by.chuprys.itcompany;

import main.java.by.chuprys.itcompany.domain.Customer;
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

        Team team = initializeData();
        Customer customer = new Customer("Grape", "+375291112233", "BigBoss",
                "email@mail.ru", "1111 2222 3333 4444");
        Requirement requirement = new Requirement(8, "Создание нового проекта",
                LocalDate.parse("2022-10-01"));
        Project project = new Project("NewProject", requirement, customer);

        ProjectEstimationService projectEstimationService = new ProjectEstimationService();
        ProjectOffer projectOffer = projectEstimationService.estimateProject(project, team, 2F);

        System.out.println("Стоимость проекта($) =" + projectOffer.getPrice() + ", Время выполнения(месяцев) =" +
                projectOffer.getExecutionTime() + ", " + projectOffer.getTeam().getTeamInfo());


    }

    public static Team initializeData() {

        Developer[] developers = new Developer[3];
        QA[] qas = new QA[2];

        Developer firstDev = new Developer("Ivan", "Ivanov", "junior", "java",
                new BigDecimal(700));
        Developer secondDev = new Developer("Bob", "Jonson", "midl", "java",
                new BigDecimal(1000));

        Developer fourthDev = new Developer("Ivan", "Ivanov", "senior", "java",
                new BigDecimal(2000));

        developers[0] = firstDev;
        developers[1] = secondDev;
        developers[2] = fourthDev;

        QA firstQa = new QA("Ivan", "Ivanov", "junior", new BigDecimal(700));
        QA secondQa = new QA("Bob", "Jonson", "midl", new BigDecimal(1000));


        qas[0] = firstQa;
        qas[1] = secondQa;

        ProjectManager firstManager = new ProjectManager("Piter", "Second", "midl",
                new BigDecimal(3000));

        LocalDateTime projectEnd = LocalDateTime.of(2021, 12, 15, 18, 00);
        return new Team(60, developers, qas, firstManager, projectEnd);

    }
}
