package com.example.springbootPro.repository;

import com.example.springbootPro.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {


}
