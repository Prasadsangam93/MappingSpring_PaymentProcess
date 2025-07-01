package com.mapping.service;


import com.mapping.entity.Address;
import com.mapping.entity.Employee;
import com.mapping.entity.Order;
import com.mapping.entity.Payment;
import com.mapping.repository.AddressRepository;
import com.mapping.repository.EmployeeRepository;
import com.mapping.repository.OrderRepository;
import com.mapping.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {


    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private OrderRepository orderRepository;
    public Payment savePayment(Payment payment) {


        Long employeeId = payment.getEmployee().getId();
        Long addressId = payment.getAddress().getId();
        Long orderId = payment.getOrder().getId();

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found: " + employeeId));
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("Address not found: " + addressId));
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found: " + orderId));

        payment.setEmployee(employee);
        payment.setAddress(address);
        payment.setOrder(order);

        return paymentRepository.save(payment);
    }
    }

