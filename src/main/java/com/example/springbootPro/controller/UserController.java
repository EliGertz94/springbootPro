package com.example.springbootPro.controller;

import com.example.springbootPro.Exceptions.CustomException;
import com.example.springbootPro.entity.User;
import com.example.springbootPro.service.UserService;
import com.example.springbootPro.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user/")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("login")
    public ResponseEntity<String> logIn(@RequestBody User user){
        try{
            return new ResponseEntity<>(userService.logIn(user.getUsername(), user.getPassword())+"", HttpStatus.OK);
        }catch (CustomException e){
            return new ResponseEntity<>(e.getMessage(),e.getHttpStatus());
        }
    }
}
