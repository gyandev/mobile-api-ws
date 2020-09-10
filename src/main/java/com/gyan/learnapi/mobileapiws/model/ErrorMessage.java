package com.gyan.learnapi.mobileapiws.model;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorMessage
{
    public ErrorMessage()
    {
    }
    public ErrorMessage(Date timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    private Date timestamp;
    private  String message;

}
