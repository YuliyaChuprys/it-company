package main.java.by.chuprys.itcompany.service;

import main.java.by.chuprys.itcompany.domain.Employee;

public class EmployeeService {

    public void getLevelOfEmployee(Employee employee) {

        int workExperienceMonth = employee.getWorkExperienceMonth();
        String level = null;
        if (workExperienceMonth < 0) {
            System.out.println("Work experience is set incorrect:" + workExperienceMonth);
        } else if (workExperienceMonth < 12) {
            level = "junior";
        } else if (workExperienceMonth > 24 & workExperienceMonth < 36) {
            level = "middle";
        } else {
            level = "senior";
        }
        employee.setRaiting(level);
    }
}
