package com.mapping.controller;

import com.mapping.entity.Employee;
import com.mapping.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emp")
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {

        log.info("Post/save called to created employee : {} ", employee);
        Employee savedEmployee= employeeService.saveEmployee(employee);

        log.info("Employee created with ID :  {}",savedEmployee.getId());
        return ResponseEntity.status((HttpStatus.CREATED)).body(savedEmployee);
    }
}