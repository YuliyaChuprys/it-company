package main.java.by.chuprys.itcompany;

import main.java.by.chuprys.itcompany.domain.Customer;
import main.java.by.chuprys.itcompany.service.EmployeeService;
import main.java.by.chuprys.itcompany.domain.Developer;
import main.java.by.chuprys.itcompany.domain.Document;
import main.java.by.chuprys.itcompany.domain.Employee;
import main.java.by.chuprys.itcompany.domain.Project;
import main.java.by.chuprys.itcompany.domain.ProjectManager;
import main.java.by.chuprys.itcompany.domain.ProjectOffer;
import main.java.by.chuprys.itcompany.domain.QA;
import main.java.by.chuprys.itcompany.domain.Requirement;
import main.java.by.chuprys.itcompany.domain.Team;
import main.java.by.chuprys.itcompany.service.ProjectEstimationService;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ITCompany {

    public static void main(String[] args) {
        Customer customer = new Customer("Grape", "+375291112233", "BigBoss",
                "email@mail.ru");
        Requirement requirement = new Requirement(20221001,"Create new cool project", 8,
                LocalDate.parse("2022-10-01"));
        Project project = new Project("NewProject", requirement, customer);
        Document document = new Document(111, "Document for Project");
        Developer fifthDev = new Developer( "dev05", "Leonard", true, new BigDecimal(500));
        fifthDev.sendWelcomeMessage();

        System.out.println(fifthDev);

        QA thirdQa = new QA("t03", "Vincent", true, new BigDecimal(300));
        QA fourthQa = new QA("t033", "David", true, new BigDecimal(500));

        Team team = initializeData();
        ProjectEstimationService projectEstimationService = new ProjectEstimationService(); //объявление объекта
        ProjectOffer projectOffer = projectEstimationService.estimateProject(document, project, team, 2F);

        System.out.println("Project price($) =" + projectOffer.getPrice() + ", Time to do(month) =" +
                projectOffer.getExecutionTime() + ", " + projectOffer.getTeam().getTeamInfo());
        thirdQa.getDepartmentName();
        System.out.println(thirdQa);
        System.out.println(fourthQa);
        System.out.println("Tester 3 и tester 4 has the same idCard? " + thirdQa.equals(fourthQa));//equals

        Employee firstEmplyee = new Employee("E01", "First", false);
        Employee secondEmplyee = new Employee("E02", "First", true);
        firstEmplyee.setWorkExperienceMonth(10);

        EmployeeService degreeOfEmployeeService = new EmployeeService();
        degreeOfEmployeeService.getLevelOfEmployee(fourthQa);

        System.out.println("Degree of employee " + fourthQa.getRaiting());

        System.out.println(firstEmplyee + ", " + secondEmplyee);
        System.out.println("Employee First and Employee Second has the same name? " + firstEmplyee.equals(secondEmplyee));//equals

    }

    public static Team initializeData() {
        Developer[] developers = new Developer[3];
        QA[] qas = new QA[2];
        Developer firstDev = new Developer("dev01", "Michelangelo", true, new BigDecimal(3500));
        Developer secondDev = new Developer("dev02", "Donatello", true, new BigDecimal(4000));
        Developer fourthDev = new Developer("dev04", "Rafael", true, new BigDecimal(5000));

        developers[0] = firstDev;
        developers[1] = secondDev;
        developers[2] = fourthDev;

        QA firstQa = new QA("t01", "Damiano", true, new BigDecimal(1000));
        QA secondQa = new QA("t02", "Stefan", true, new BigDecimal(900));

        qas[0] = firstQa;
        qas[1] = secondQa;

        ProjectManager firstManager = new ProjectManager( "pm01", "Peter", true,
                "ProjectManager", new BigDecimal(3000));
        firstManager.setSecondName("Mamonov");

        //LocalDateTime projectEnd = LocalDateTime.of(2021, 12, 15, 18, 00);
        return new Team(60, developers, qas, firstManager);
    }

}
