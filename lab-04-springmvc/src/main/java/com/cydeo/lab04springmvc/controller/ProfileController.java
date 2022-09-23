package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.model.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class ProfileController {

    @RequestMapping("/profile")
    public String profile(Model model) {
        Profile profile = new Profile();
        profile.setName("Hamza");
        profile.setSurname("Ali");
        profile.setUserName("hamzasali");
        profile.setEmail("hamza@gmail.com");
        profile.setPhoneNumber("9292137493");
        profile.setCreatedDate(LocalDateTime.now());
        model.addAttribute("profile", profile);
        return "profile/profile-info";
    }
}
