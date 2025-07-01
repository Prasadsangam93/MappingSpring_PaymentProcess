package com.mapping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PaymentResponseDTO {

    private Long id;
    private Double amount;
    private EmployeeDTO employee;
    private AddressDTO address;
    private OrderDTO order;
}
