package com.practice.mvc.controller;

import com.practice.mvc.entity.EmployeeEntity;
import com.practice.mvc.service.employee.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeEntity> getEmployee(@PathVariable Long empId){
        return ResponseEntity.ok(employeeService.getEmployee(empId));
    }

    @DeleteMapping("/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long empId){
        return ResponseEntity.ok("DEleted");
    }

    @PutMapping
    public ResponseEntity<EmployeeEntity> saveOrUpdatedEmployee(@RequestBody EmployeeEntity employeeEntity){
        return ResponseEntity.ok(employeeService.saveOrUpdatedEmployee(employeeEntity));
    }
}
