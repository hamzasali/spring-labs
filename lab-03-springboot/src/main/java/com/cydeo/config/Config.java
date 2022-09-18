package com.cydeo.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.cydeo")
public class Config {

    @Bean
    public Faker faker(){
        return new Faker();
    }
}
