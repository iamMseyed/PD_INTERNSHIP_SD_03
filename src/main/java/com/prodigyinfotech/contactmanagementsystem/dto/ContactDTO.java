package com.prodigyinfotech.contactmanagementsystem.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {
    private  long id;
    private String name;
    private String email;
    private String phoneNumber;
}