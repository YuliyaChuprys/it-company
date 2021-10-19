package by.chuprys.itcompany.service;

import by.chuprys.itcompany.domain.Educable;
import by.chuprys.itcompany.domain.Employee;

public interface IEmployeeService {

    void getLevelOfEmployee(Employee employee);

    void sendToCourse(Educable educable);

}
