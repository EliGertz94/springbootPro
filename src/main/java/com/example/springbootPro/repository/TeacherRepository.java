package com.example.springbootPro.repository;

import com.example.springbootPro.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    boolean existsByName(String name);
}
