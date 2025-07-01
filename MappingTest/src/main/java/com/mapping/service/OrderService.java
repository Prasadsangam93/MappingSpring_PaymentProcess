package com.mapping.service;

import com.mapping.entity.Address;
import com.mapping.entity.Employee;
import com.mapping.entity.Order;
import com.mapping.repository.AddressRepository;
import com.mapping.repository.EmployeeRepository;
import com.mapping.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Order saveOrder(Order order) {
        Long employeeId = order.getEmployee().getId();
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));

        order.setEmployee(employee);
        return orderRepository.save(order);
    }
}
