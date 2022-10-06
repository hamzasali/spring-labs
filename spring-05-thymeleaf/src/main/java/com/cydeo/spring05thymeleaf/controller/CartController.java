package com.cydeo.spring05thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

    @GetMapping("/cart")
    public String create(){

        return "/cart/show-cart";
    }
}
