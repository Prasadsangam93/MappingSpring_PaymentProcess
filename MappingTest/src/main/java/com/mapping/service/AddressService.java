package com.mapping.service;

import com.mapping.entity.Address;
import com.mapping.entity.Employee;
import com.mapping.repository.AddressRepository;
import com.mapping.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {


    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Address saveAddress(Address address) {
        Long employeeId = address.getEmployee().getId();

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));

        address.setEmployee(employee);
        return addressRepository.save(address);
    }
}
