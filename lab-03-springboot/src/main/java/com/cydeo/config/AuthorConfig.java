package com.cydeo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "author")
@Getter
@Setter
public class AuthorConfig {
    private String name;
    private String surName;
    private String phone;
    private List<String> socialMedia;
    private String email;
}
