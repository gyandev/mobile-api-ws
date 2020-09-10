package com.gyan.learnapi.mobileapiws.exception;

import com.gyan.learnapi.mobileapiws.model.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class UserException extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest webRequest)
    {
        String errorMessageDes = ex.getLocalizedMessage();
        if(errorMessageDes == null) errorMessageDes = ex.toString();
        ErrorMessage errorMessage =new ErrorMessage(new Date(), ex.getLocalizedMessage());
        return new ResponseEntity<>(errorMessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})
    public ResponseEntity<Object> handleNullPointerException(Exception ex, WebRequest webRequest)
    {
        String errorMessageDes = ex.getLocalizedMessage();
        if(errorMessageDes == null) errorMessageDes = ex.toString();
        ErrorMessage errorMessage =new ErrorMessage(new Date(), ex.getLocalizedMessage());
        return new ResponseEntity<>(errorMessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
