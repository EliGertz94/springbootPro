package com.example.springbootPro.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private Subject subject;




    @JsonIgnore
    @OneToMany(mappedBy = "teacher" ,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Student> students;
}
