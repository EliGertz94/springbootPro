package com.example.springbootPro.service.impl;

import com.example.springbootPro.Exceptions.CustomException;
import com.example.springbootPro.repository.UserRepository;
import com.example.springbootPro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean logIn(String username, String password) throws CustomException {

        if(!userRepository.existsByUsernameAndPassword(username,password)){
            throw new CustomException("wrong email or password", HttpStatus.BAD_REQUEST);
        }

        return true;

    }
}
