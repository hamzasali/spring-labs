package com.cydeo.lab04springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/login/{email}/{phoneNumber}")
    public String login(Model model, @PathVariable String email, @PathVariable String phoneNumber) {
        System.out.println(email);
        System.out.println(phoneNumber);
        model.addAttribute("loginMessage", "Login Successful");
        return "login/login-info";
    }
}
