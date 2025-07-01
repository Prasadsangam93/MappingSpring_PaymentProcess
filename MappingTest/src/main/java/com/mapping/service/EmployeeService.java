package com.mapping.service;
;

import com.mapping.entity.Employee;
import com.mapping.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeService {


    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Employee saveEmployee(Employee employee) {

        log.info("Saving employee with name : {}",employee);
        return employeeRepository.save(employee);
//        Employee employee = new Employee();
//        employee.setName(dto.getName());
//
//        List<Address> addresses = addressRepository.findAllById(dto.getAddressIds());
//        addresses.forEach(a -> a.setEmployee(employee));
//        employee.setAddresses(addresses);
//
//        List<Order> orders = orderRepository.findAllById(dto.getOrderIds());
//        orders.forEach(o -> o.setEmployee(employee));
//        employee.setOrders(orders);
     //   return employeeRepository.save(employee);

    }


}
      

