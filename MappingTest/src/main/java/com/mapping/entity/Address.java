package com.mapping.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
@Entity
public class Address {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)

        private Long id;

        private String city;
        private String state;
        private String pincode;

        @ManyToOne
        @JoinColumn(name = "employee_id")
        private Employee employee;

}
