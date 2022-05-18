package com.practice.mvc.service.employee;

import com.practice.mvc.entity.EmployeeEntity;
import com.practice.mvc.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }






    @Override
    @Cacheable(cacheNames = "employee",key = "#empId")
    public EmployeeEntity getEmployee(Long empId) {
        log.info("getting the Employee from database for id ::{}",empId);
        EmployeeEntity employeeEntity = employeeRepository.findById(empId).get();
        log.info("employee obj::{}",employeeEntity);
        return employeeEntity;
    }

    @Override
    @CachePut(cacheNames = "employee", key ="#employeeEntity.empId")
    public EmployeeEntity saveOrUpdatedEmployee(EmployeeEntity employeeEntity) {
        if (employeeRepository.existsById(employeeEntity.getEmpId())) {
            log.info("updating the employee");
        }else {
            log.info("adding the employee");
        }
        return employeeRepository.save(employeeEntity);
    }

    @Override
    @CacheEvict(cacheNames = "employee",key = "#empId")
    public void deleteEmployee(Long empId) {
        log.info("deleting the employee::{}",empId);
        employeeRepository.deleteById(empId);
    }
}
