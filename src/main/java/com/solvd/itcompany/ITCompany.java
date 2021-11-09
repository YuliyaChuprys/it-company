package com.solvd.itcompany;

import com.solvd.itcompany.domain.LeadDevelop;
import com.solvd.itcompany.domain.IDocumentAction;
import com.solvd.itcompany.domain.Customer;
import com.solvd.itcompany.domain.LeadQa;
import com.solvd.itcompany.domain.OfficeManager;
import com.solvd.itcompany.exeption.InvalidDocumentData;
import com.solvd.itcompany.exeption.InvalidWorkExperienceMonth;
import com.solvd.itcompany.domain.Resource;
import com.solvd.itcompany.service.EducationService;
import com.solvd.itcompany.service.EmployeeService;
import com.solvd.itcompany.domain.ArrivalDepartureJournal;
import com.solvd.itcompany.domain.Cleaning;
import com.solvd.itcompany.domain.DayWeek;
import com.solvd.itcompany.domain.Developer;
import com.solvd.itcompany.domain.Document;
import com.solvd.itcompany.domain.Employee;
import com.solvd.itcompany.domain.Project;
import com.solvd.itcompany.domain.ProjectManager;
import com.solvd.itcompany.domain.ProjectOffer;
import com.solvd.itcompany.domain.QA;
import com.solvd.itcompany.domain.Requirement;
import com.solvd.itcompany.domain.Team;
import com.solvd.itcompany.service.FileService;
import com.solvd.itcompany.service.IEducationService;
import com.solvd.itcompany.service.IEmployeeService;
import com.solvd.itcompany.service.IProjectEstimationService;
import com.solvd.itcompany.service.ProjectEstimationService;
import com.solvd.itcompany.threads.Connection;
import com.solvd.itcompany.threads.ConnectionRun;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ITCompany {

    private static final Logger LOGGER = LogManager.getLogger(ITCompany.class);

    public static void main(String[] args) throws IOException, InvocationTargetException {

        Customer customer = new Customer("Grape", "+375291112233", "BigBoss",
                "email@mail.ru");
        Requirement requirement = new Requirement(20221001, "Create new cool project", 8,
                LocalDate.parse("2022-10-01"));
        Project project = new Project("NewProject", requirement, customer);

        Runnable lambda = () -> System.out.println("Work with file is done.");
        // lambda.run();

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
        switch (stageProject) {
            case PLANNING:
                System.out.println("Project is on stage " + stageProject);
                break;
            case DEVELOPING:
                System.out.println("Stage of project is " + stageProject);
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
        QA sixthQa = new QA("t044", "Joe", false, new BigDecimal(200));

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

        List<QA> qas = new ArrayList<>();
        qas.add(thirdQa);
        qas.add(fourthQa);
        qas.add(sixthQa);

        Employee firstEmployee = new Employee("E01", "First", false);
        try {
            firstEmployee.setWorkExperienceMonth(10);
        } catch (InvalidWorkExperienceMonth e) {
            e.printStackTrace();
        }
        Employee secondEmployee = new Employee("E02", "Second", true);
        Employee thirdEmployee = new Employee("E03", "Third", true);
        Employee forthEmployee = new Employee("E04", "Forth", false);

        List<Employee> employees = new ArrayList<>();
        employees.add(firstEmployee);
        employees.add(secondEmployee);
        employees.add(thirdEmployee);
        employees.add(forthEmployee);

        /**
         * Create Streaming
         */

        List<String> sortedNames = employees.stream()
                .map(Employee::getFirstName)
                .filter(firstName -> firstName.startsWith("F"))
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());


        Arrays.asList(qas, employees).stream()
                .flatMap(list -> list.stream())
                .forEach(System.out::println);

        Optional<QA> firstQaInList = qas.stream().findFirst();
        System.out.println(firstQaInList);

        QA lastQa = qas.stream().skip(qas.size() - 1).findAny().orElse(null);
        System.out.println(lastQa);

        Integer maxWorkExp = employees.stream()
                .map(Employee::getWorkExperienceMonth)
                .max(Integer::compare)
                .orElseThrow(IllegalStateException::new);
        System.out.println("Max Work of Experience: " + maxWorkExp);

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

        OfficeManager<?, ?> firstOM = new OfficeManager<>("om01", "Mary", true, true);

        ArrivalDepartureJournal.getArrivalDepartureJournal().addJournalInfo("First Employee arrived");
        ArrivalDepartureJournal.getArrivalDepartureJournal().addJournalInfo("Second Employee arrived");
        ArrivalDepartureJournal.getArrivalDepartureJournal().addJournalInfo("Third Employee arrived");

        ArrivalDepartureJournal.getArrivalDepartureJournal().showJournalInfo();

        OfficeManager<?, ?> officeManager = new OfficeManager<>("om001", "Ann", true, true);
        Cleaning<?, ?> cleaning = new Cleaning<>("c001", "Any", true, true);
        officeManager.setDayWeek(DayWeek.FRI);
        officeManager.treatСolleagues();
        cleaning.setDayWeek(DayWeek.FRI);
        cleaning.generalClean();

        FileService fileService = new FileService();
        List<String> doc = fileService.readFile("C:\\Users\\Professional\\IdeaProjects\\it-company\\file.txt");
        HashMap<String, Integer> fileMap = fileService.countWord(doc);
        StringBuilder result = fileService.sortBy(fileMap);
        fileService.writeToFile(result, "src\\main\\resources\\SortedText.txt", lambda);

        /**
         * Reflection with Requirement Class
         * Create object secondRequirement, initialize, check methods
         */

        Requirement secondRequirement = null;
        try {
            Class<?> reqClass = Class.forName(Requirement.class.getName());
            Class<?>[] params = {int.class, String.class, int.class, LocalDate.class};
            secondRequirement = (Requirement) reqClass.getConstructor(params).newInstance(02, "Second project", 15,
                    LocalDate.parse("2023-01-01"));
            Method getFeatures = secondRequirement.getClass().getDeclaredMethod("getFeatures");
            Method getStartProject = secondRequirement.getClass().getDeclaredMethod("getStartProjectDate1"); //mistake in name
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(secondRequirement);

        IntStream.range(0, 5)
                .boxed()
                .forEach(integer -> {
                    Connection connection = new Connection("Connection" + integer);
                    connection.start();
                });

        IntStream.range(0, 5)
                .boxed()
                .forEach(integer -> {
                    ConnectionRun connectionRun = new ConnectionRun("ConnectionRun" + integer);
                    Thread thread = new Thread(connectionRun);
                    thread.start();
                });

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(0, 10)
                .boxed()
                .forEach(integer -> {
                    executorService.submit(() -> {
                        System.out.println("In thread " + integer);
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                });

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Use CompletableFuture");
           return "End CompletableFuture";
                   });
        System.out.println("After CompletableFuture use");
        String result1 = get(future);
        System.out.println(result1 + "after waiting");

        IntStream.range(0, 10)
                .boxed()
                .forEach(integer -> {
                    Thread thread = new Thread(() -> {
                        System.out.println(integer + " Thread started");
                        // Connection connection = ConnectionPool.getInstance(5);
                    });
                });
    }

    private static String get(CompletableFuture<String> future){
        String result1 = null;
        try {
            result1 = future.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException| TimeoutException e) {
            e.printStackTrace();
        }
        return result1;
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

    public enum StageProject {
        PLANNING, DEVELOPING, TESTING, CLOSE
    }
}