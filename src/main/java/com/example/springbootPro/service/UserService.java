package com.example.springbootPro.service;

import com.example.springbootPro.Exceptions.CustomException;

public interface UserService {

    boolean logIn(String username , String password) throws CustomException;
}
