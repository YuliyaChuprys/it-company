package main.java.by.chuprys.itcompany.service;

import main.java.by.chuprys.itcompany.domain.Educable;
import main.java.by.chuprys.itcompany.domain.Employee;

public class EmployeeService implements IEmployeeService {

    @Override
    public void getLevelOfEmployee(Employee employee) {
        int workExperienceMonth = employee.getWorkExperienceMonth();
        String level = null;
        if (workExperienceMonth < 0) {
            System.out.println("Work experience is set incorrect:" + workExperienceMonth);
        } else if (workExperienceMonth < 12) {
            level = "junior";
        } else if (workExperienceMonth > 12 & workExperienceMonth < 24) {
            level = "middle";
        } else {
            level = "senior";
        }
        employee.setRating(level);
    }

    @Override
    public void sendToCourse(Educable educable) {
        String level = educable.getLevel();
        IEducationService educationService = new EducationService();
        if (level.equals("junior")) {
            educationService.upLevelToMiddle(educable);
        } else if (level.equals("middle")) {
            educationService.upLevelToSenior(educable);
        }
    }

}
