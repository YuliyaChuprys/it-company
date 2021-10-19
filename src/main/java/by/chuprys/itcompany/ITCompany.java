package main.java.by.chuprys.itcompany;

import main.java.by.chuprys.itcompany.domain.Customer;
import main.java.by.chuprys.itcompany.domain.IDocumentAction;
import main.java.by.chuprys.itcompany.exeption.InvalidDocumentData;
import main.java.by.chuprys.itcompany.exeption.InvalidWorkExperienceMonth;
import main.java.by.chuprys.itcompany.domain.Resource;
import main.java.by.chuprys.itcompany.service.EducationService;
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
import main.java.by.chuprys.itcompany.service.IEducationService;
import main.java.by.chuprys.itcompany.service.IEmployeeService;
import main.java.by.chuprys.itcompany.service.IProjectEstimationService;
import main.java.by.chuprys.itcompany.service.ProjectEstimationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ITCompany {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(ITCompany.class);

    public static void main(String[] args) {


        Customer customer = new Customer("Grape", "+375291112233", "BigBoss",
                "email@mail.ru");
        Requirement requirement = new Requirement(20221001, "Create new cool project", 8,
                LocalDate.parse("2022-10-01"));

        /**
         * Craete HashMap for Employes with key-value: id Employee, in Vocation - true, in Work - false
         **/
        Map<String, Boolean> iDEmployeeIsInVocation = new HashMap();
        iDEmployeeIsInVocation.put("d007", true);
        iDEmployeeIsInVocation.put("qa005", true);
        iDEmployeeIsInVocation.put("pm008", true);


        Project project = new Project("NewProject", requirement, customer);

        Set<Project> projects = new TreeSet<>();
        projects.add(project);

        IDocumentAction document = new Document(011, "Best project ever");

        /**
         * Check DocumentDescription
         */
        //document.setDocumentTitle("Report"); //This show us exeption
        try {
            document.setDocumentDescription("-rfrf");
            document.setDocumentAuthor("R2D2");
        } catch (InvalidDocumentData e) {
            LOGGER.debug("Document Description is invalid. " + e.getMessage());
            LOGGER.debug("Invalid document Author");
        } finally {
            LOGGER.debug("After operation");
        }

        try (Resource resourse = new Resource()) {
            System.out.println(" ");
        }

        document.docPrint();
        Developer fifthDev = new Developer("dev05", "Leonard", true, new BigDecimal(500));

        Team team = initializeData();
        IProjectEstimationService projectEstimationService = new ProjectEstimationService();
        ProjectOffer projectOffer = projectEstimationService.estimateProject(document, project, team, 2F);

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

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(firstEmployee);
        employeeList.add(secondEmployee);

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

        System.out.println("Degree of employee " + fourthQa.getFirstName() + " " + fourthQa.getRating());

        employeeService.sendToCourse(fourthQa);

        System.out.println("Degree of employee after courses " + fourthQa.getFirstName() + " " + fourthQa.getRating());

        System.out.println(firstEmployee + ", " + secondEmployee);
        System.out.println("Employee First and Employee Second has the same name? " + firstEmployee.equals(secondEmployee));//equals

    }

    public static Team initializeData() {

        Developer firstDev = new Developer("dev01", "Michelangelo", true, new BigDecimal(3500));
        Developer secondDev = new Developer("dev02", "Donatello", true, new BigDecimal(4000));
        Developer fourthDev = new Developer("dev04", "Rafael", true, new BigDecimal(5000));

        QA firstQa = new QA("t01", "Damiano", true, new BigDecimal(1000));
        QA secondQa = new QA("t02", "Stefan", true, new BigDecimal(900));

        Set<Developer> developers = new HashSet<>();
        developers.add(firstDev);
        developers.add(secondDev);
        developers.add(fourthDev);

        Set<QA> qas = new HashSet<>();
        qas.add(firstQa);
        qas.add(secondQa);

        ProjectManager firstManager = new ProjectManager("pm01", "Peter", true,
                "ProjectManager", new BigDecimal(3000));
        firstManager.setSecondName("Mamonov");

        Set<ProjectManager> projectManagers = new HashSet<>();
        projectManagers.add(firstManager);

        return new Team(60, developers, qas, firstManager);
    }


}
