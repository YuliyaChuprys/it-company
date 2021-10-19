package main.java.by.chuprys.itcompany.service;

import main.java.by.chuprys.itcompany.domain.Educable;
import main.java.by.chuprys.itcompany.domain.Employee;

public interface IEmployeeService {

    void getLevelOfEmployee(Employee employee);

    void sendToCourse(Educable educable);

}
