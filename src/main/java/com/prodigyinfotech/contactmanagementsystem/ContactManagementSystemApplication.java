package com.prodigyinfotech.contactmanagementsystem;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.annotation.Validated;

@SpringBootApplication
public class ContactManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactManagementSystemApplication.class, args);
    }
    @Bean
    public ModelMapper getModelMappedBean(){
        return new ModelMapper();
    }
}
