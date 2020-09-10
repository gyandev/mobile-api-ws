package com.gyan.learnapi.mobileapiws.controller;

import com.gyan.learnapi.mobileapiws.exception.UserServiceException;
import com.gyan.learnapi.mobileapiws.model.UpdateUserDetailsRequest;
import com.gyan.learnapi.mobileapiws.model.UserDetailsRequest;
import com.gyan.learnapi.mobileapiws.model.UserResponse;
import com.gyan.learnapi.mobileapiws.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;


@RestController
@RequestMapping("users")  //http://localhost:8080/users
public class UserContoller {

    Map<String,UserResponse> users;

    @Autowired
    UserServiceImpl userService;
    @GetMapping
    public String getUser(@RequestParam(value = "page", defaultValue = "1")
                                  int page, @RequestParam(value = "limit", defaultValue = "50")
                                  int limit, @RequestParam(value = "sort", defaultValue = "desc",
            required = false) String sort) {
        return "get user was called " + page + " and limit " + limit + " and sort " + sort;
    }

    @GetMapping(path = "/userId",
            produces =
                    {
                            MediaType.APPLICATION_JSON_VALUE,
                            MediaType.APPLICATION_XML_VALUE
                    })
    public ResponseEntity<UserResponse> getUser(@PathVariable String userId) {

        if(true) throw  new UserServiceException("A user service expection is thrown");
        if(users.containsKey(userId))
        {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping(
            produces =
                    {
                            MediaType.APPLICATION_JSON_VALUE,
                            MediaType.APPLICATION_XML_VALUE
                    },
            consumes =
                    {
                            MediaType.APPLICATION_JSON_VALUE,
                            MediaType.APPLICATION_XML_VALUE
                    }
    )
    public ResponseEntity<UserResponse> createUser(@Valid  @RequestBody UserDetailsRequest userDetailsRequest)
    {
        UserResponse userResponse =userService.createUser(userDetailsRequest);
        return  new ResponseEntity<>(userResponse,HttpStatus.OK);

    }

    @PutMapping(path = "/userId",
            produces =
                    {
                            MediaType.APPLICATION_JSON_VALUE,
                            MediaType.APPLICATION_XML_VALUE
                    },
            consumes =
                    {
                            MediaType.APPLICATION_JSON_VALUE,
                            MediaType.APPLICATION_XML_VALUE
                    }
    )
    public ResponseEntity<UserResponse> updateUser(@PathVariable String userId,@Valid
    @RequestBody UpdateUserDetailsRequest updateUserDetailsRequest)
    {
        UserResponse userResponse = users.get(userId);
        updateUserDetailsRequest.setFirstName(userResponse.getFirstName());
        updateUserDetailsRequest.setLastName(userResponse.getLastName());
        users.put(userId,userResponse);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);

    }

}
