package com.gyan.learnapi.mobileapiws.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDetailsRequest
{
    @NotNull(message = "first Name cannot be empty")
    @Size(min = 2, message = "Size must be more than two characters")
    private String firstName;
    private String lastName;
    @NotNull(message = "Email cannot be null")
    @Email
    private String email;
    @NotNull
    @Size(min = 8 , max=16 , message = "Password must greater than or equal to 8 but less than 16 characters")
    private String password;
}
