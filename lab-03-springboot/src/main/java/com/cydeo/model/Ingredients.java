package com.cydeo.model;

import com.cydeo.enums.QuantityType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Ingredients {
    private String name;
    private int quantity;
    private QuantityType quantityType;
}
