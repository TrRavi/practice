package com.practice.mvc.service.employee;

import com.practice.mvc.entity.EmployeeEntity;
import org.springframework.stereotype.Service;


public interface EmployeeService {

    EmployeeEntity getEmployee(Long empId);

    void deleteEmployee(Long empId);

    EmployeeEntity saveOrUpdatedEmployee(EmployeeEntity employeeEntity);
}
