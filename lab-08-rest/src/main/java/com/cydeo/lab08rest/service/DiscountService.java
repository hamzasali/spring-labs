package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.DiscountDTO;

import java.util.List;

public interface DiscountService {

    List<DiscountDTO> findAll();

    List<DiscountDTO> findAllByName(String name);

    DiscountDTO findByName(String name);

    DiscountDTO create(DiscountDTO discount);

    DiscountDTO update(DiscountDTO discount);
}
