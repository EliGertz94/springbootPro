package com.example.springbootPro.entity.DTO;

import lombok.Data;

@Data
public class StudentRequest {
    private Long id;

    private Long teacherId;

    private String name;

    private int age;
}
