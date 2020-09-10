package com.gyan.learnapi.mobileapiws.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UpdateUserDetailsRequest
{

    @NotNull(message = "first Name cannot be empty")
    @Size(min = 2, message = "Size must be more than two characters")
    private String firstName;
    private String lastName;}
