package com.gyan.learnapi.mobileapiws.service;

import com.gyan.learnapi.mobileapiws.Utility.UserUtility;
import com.gyan.learnapi.mobileapiws.model.UserDetailsRequest;
import com.gyan.learnapi.mobileapiws.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService
{

    Map<String,UserResponse> users;
    UserUtility userUtility;
    
    public UserServiceImpl()
    {
    }
    @Autowired
    UserServiceImpl(UserUtility userUtility )
    {
        this.userUtility =userUtility;
    }
    public   UserResponse createUser(UserDetailsRequest userDetailsRequest)
    {

        UserResponse userResponse = new UserResponse();
        userResponse.setFirstName(userDetailsRequest.getFirstName());
        userResponse.setLastName(userDetailsRequest.getLastName());
        userResponse.setEmail(userDetailsRequest.getEmail());

        String userId = userUtility.generateUserId();
        userResponse.setUserId(userId);
        if(users == null) users =new HashMap<>();
        users.put(userId , userResponse);
        return userResponse;
    }
}
