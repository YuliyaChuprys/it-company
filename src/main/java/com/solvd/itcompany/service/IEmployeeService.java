package com.solvd.itcompany.service;

import com.solvd.itcompany.domain.Educable;
import com.solvd.itcompany.domain.Employee;

public interface IEmployeeService {

    void getLevelOfEmployee(Employee employee);

    void sendToCourse(Educable educable);

}
