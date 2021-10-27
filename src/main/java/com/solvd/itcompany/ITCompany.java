package com.solvd.itcompany;

import com.solvd.itcompany.domain.IDocumentAction;
import com.solvd.itcompany.domain.Customer;
import com.solvd.itcompany.domain.LeadDevelop;
import com.solvd.itcompany.domain.LeadQa;
import com.solvd.itcompany.domain.Singleton;
import com.solvd.itcompany.exeption.InvalidDocumentData;
import com.solvd.itcompany.exeption.InvalidWorkExperienceMonth;
import com.solvd.itcompany.domain.Resource;
import com.solvd.itcompany.service.EducationService;
import com.solvd.itcompany.service.EmployeeService;
import com.solvd.itcompany.domain.Developer;
import com.solvd.itcompany.domain.Document;
import com.solvd.itcompany.domain.Employee;
import com.solvd.itcompany.domain.Project;
import com.solvd.itcompany.domain.ProjectManager;
import com.solvd.itcompany.domain.ProjectOffer;
import com.solvd.itcompany.domain.QA;
import com.solvd.itcompany.domain.Requirement;
import com.solvd.itcompany.domain.Team;
import com.solvd.itcompany.service.IEducationService;
import com.solvd.itcompany.service.IEmployeeService;
import com.solvd.itcompany.service.IProjectEstimationService;
import com.solvd.itcompany.service.ProjectEstimationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ITCompany {

    private static final Logger LOGGER = LogManager.getLogger(ITCompany.class);

    public static void main(String[] args) {


        Customer customer = new Customer("Grape", "+375291112233", "BigBoss",
                "email@mail.ru");
        Requirement requirement = new Requirement(20221001, "Create new cool project", 8,
                LocalDate.parse("2022-10-01"));
        Project project = new Project("NewProject", requirement, customer);

        /**
         * Create HashMap for Employees with key-value: id Employee, in Vocation - true, in Work - false
         **/
        Map<String, Boolean> iDEmployeeIsInVocations = new HashMap<>();
        iDEmployeeIsInVocations.put("d007", true);
        iDEmployeeIsInVocations.put("qa005", true);
        iDEmployeeIsInVocations.put("pm008", true);

        Set<Project> projects = new TreeSet<>();
        projects.add(project);

        IDocumentAction document = new Document(011, "Best project ever");

        /**
         * Check DocumentDescription
         */
        //document.setDocumentTitle("Report"); //This show us exception
        try {
            document.setDocumentDescription("-rfrf");
            document.setDocumentAuthor("R2D2");
        } catch (InvalidDocumentData e) {
            LOGGER.debug("Document Description is invalid. " + e.getMessage());
            LOGGER.debug("Invalid document Author");
        }

        try (Resource resource = new Resource()) {
            System.out.println(" ");
        }

        document.docPrint();
        Developer fifthDev = new Developer("dev05", "Leonard", true, new BigDecimal(500));

        Team team = initializeData();
        IProjectEstimationService projectEstimationService = new ProjectEstimationService();
        ProjectOffer projectOffer = projectEstimationService.estimateProject(document, project, team, 2F);

        StageProject stageProject = StageProject.PLANNING;
        switch (stageProject){
            case PLANNING:
                System.out.println("Project is on stage " + stageProject);
                break;
            case DEVELOPING:
                System.out.println("Stage of project is "+ stageProject);
                break;
            case TESTING:
                System.out.println("Project is in " + stageProject);
                break;
            case CLOSE:
                System.out.println("Project is on last stage: " + stageProject);
        }

        System.out.println("Project price($) =" + projectOffer.getPrice() + ", Time to do(month) =" +
                projectOffer.getExecutionTime() + ", " + projectOffer.getTeam().getTeamInfo());

        fifthDev.sendWelcomeMessage();
        System.out.println(fifthDev);

        QA thirdQa = new QA("t03", "Vincent", true, new BigDecimal(300));
        QA fourthQa = new QA("t033", "David", true, new BigDecimal(500));

        try {
            fourthQa.setWorkExperienceMonth(5);
        } catch (InvalidWorkExperienceMonth e) {
            System.out.println("Work of experience set invalid. " + e.getMessage());
        } finally {
            System.out.println("After operation");
        }

        System.out.println(thirdQa);
        System.out.println(fourthQa);
        System.out.println("Tester 3 и tester 4 has the same idCard? " + thirdQa.equals(fourthQa));

        Employee firstEmployee = new Employee("E01", "First", false);
        Employee secondEmployee = new Employee("E02", "First", true);

        List<Employee> employees = new ArrayList<>();
        employees.add(firstEmployee);
        employees.add(secondEmployee);

        LeadQa<ProjectManager<?, ?, ?>, LeadDevelop<?, ?, ?>, LeadQa<?, ?, ?>> leadQa =
                new LeadQa<>("LQA01", "Iva", true, "Testing");
        List<?> managers = new ArrayList<>();

        System.out.println(leadQa);

        try {
            firstEmployee.setWorkExperienceMonth(-2);
        } catch (InvalidWorkExperienceMonth e) {
            LOGGER.debug("Work of experience set invalid");
        } finally {
            LOGGER.debug("After operation");
        }

        IEducationService educationService = new EducationService();
        IEmployeeService employeeService = new EmployeeService(educationService);
        employeeService.getLevelOfEmployee(fourthQa);

        System.out.println("Degree of employees " + fourthQa.getFirstName() + " " + fourthQa.getRating());

        employeeService.sendToCourse(fourthQa);

        System.out.println("Degree of employees after courses " + fourthQa.getFirstName() + " " + fourthQa.getRating());

        System.out.println(firstEmployee + ", " + secondEmployee);
        System.out.println("Employee First and Employee Second has the same name? " + firstEmployee.equals(secondEmployee));//equals

        Singleton director = Singleton.getDirector();
        System.out.println(director);

    }

    public static Team initializeData() {

        Developer firstDev = new Developer("dev01", "Michelangelo", true, new BigDecimal(3500));
        Developer secondDev = new Developer("dev02", "Donatello", true, new BigDecimal(4000));
        Developer fourthDev = new Developer("dev04", "Rafael", true, new BigDecimal(5000));

        QA firstQa = new QA("t01", "Damiano", true, new BigDecimal(1000));
        QA secondQa = new QA("t02", "Stefan", true, new BigDecimal(900));

        List<Developer> developers = new ArrayList<>();
        developers.add(firstDev);
        developers.add(secondDev);
        developers.add(fourthDev);

        List<QA> qas = new ArrayList<>();
        qas.add(firstQa);
        qas.add(secondQa);

        ProjectManager<?, ?, ?> firstManager = new ProjectManager<>("pm01", "Peter", true,
                "ProjectManager", new BigDecimal(3000));
        firstManager.setSecondName("Momonov");

        return new Team(60, developers, qas, firstManager);

    }

    public  enum StageProject { PLANNING, DEVELOPING, TESTING, CLOSE }

}
