package com.gyan.learnapi.mobileapiws.Utility;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserUtility
{

    public String generateUserId()
    {
        return UUID.randomUUID().toString();
    }
}
