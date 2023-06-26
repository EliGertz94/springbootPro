package com.example.springbootPro.entity.DTO;

import com.example.springbootPro.entity.Subject;
import lombok.Data;

@Data
public class TeacherRequest {

    private String username;
    private String password;
    private String name;

    private int age;

    private Subject subject;


}
