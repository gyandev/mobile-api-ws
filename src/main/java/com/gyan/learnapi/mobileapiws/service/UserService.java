package com.gyan.learnapi.mobileapiws.service;

import com.gyan.learnapi.mobileapiws.model.UserDetailsRequest;
import com.gyan.learnapi.mobileapiws.model.UserResponse;

public interface UserService
{
    public UserResponse createUser(UserDetailsRequest userDetailsRequest);
}
