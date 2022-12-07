package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.CustomerService;
import com.cydeo.lab08rest.service.impl.CustomerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerServiceImpl customerServiceImpl) {
        this.customerService = customerServiceImpl;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getCustomerList() {
        return ResponseEntity
                .ok(new ResponseWrapper("Customers Retrieved",
                        customerService.findAll(), HttpStatus.OK));
    }

    @GetMapping("/{email}")
    public ResponseEntity<ResponseWrapper> getCustomerListByEmail(@PathVariable String email) {
        return ResponseEntity
                .ok(new ResponseWrapper("Customers Retrieved by email",
                        customerService.findByEmail(email), HttpStatus.OK));
    }

    public ResponseEntity<ResponseWrapper> createCustomer(@RequestBody CustomerDTO customer) {

        return ResponseEntity.ok(new ResponseWrapper("Customer Created",
                customerService.create(customer), HttpStatus.OK));
    }

//    public ResponseEntity<ResponseWrapper> updateCustomer(@RequestBody CustomerDTO customer) {
//    }
}
