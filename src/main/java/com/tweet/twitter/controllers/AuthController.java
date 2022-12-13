package com.tweet.twitter.controllers;


import com.tweet.twitter.dtos.RegisterDto;
import com.tweet.twitter.exception.EmailAlreadyTakenException;
import com.tweet.twitter.models.User;
import com.tweet.twitter.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@RequestMapping("/auth")
@RestController
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @ExceptionHandler({EmailAlreadyTakenException.class})
    public ResponseEntity<String> handleEmailTaken(){
        return new ResponseEntity<String>("The email already in use", HttpStatus.CONFLICT);
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody RegisterDto registerDto){
        return userService.registerUser(registerDto);

    }


}
