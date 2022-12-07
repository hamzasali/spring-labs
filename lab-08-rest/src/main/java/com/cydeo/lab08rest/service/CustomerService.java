package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO findById(Long id);

    List<CustomerDTO> findAll();

    CustomerDTO findByEmail(String email);

    CustomerDTO create(CustomerDTO customer);

    CustomerDTO update(CustomerDTO customer);
}
