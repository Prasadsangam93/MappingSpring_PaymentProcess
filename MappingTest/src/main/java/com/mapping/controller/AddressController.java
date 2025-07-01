package com.mapping.controller;


import com.mapping.entity.Address;
import com.mapping.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    @PostMapping("/save")
    public ResponseEntity<Address> save(@RequestBody Address address) {
        return ResponseEntity.ok(addressService.saveAddress(address));
    }

}
