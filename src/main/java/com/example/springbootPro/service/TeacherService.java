package com.example.springbootPro.service;

import com.example.springbootPro.Exceptions.CustomException;
import com.example.springbootPro.entity.Student;
import com.example.springbootPro.entity.Teacher;
import com.example.springbootPro.entity.User;

public interface TeacherService {

    Teacher addTeacher(Teacher teacher, User user) throws CustomException;

    Student addStudent(Student student,Long teacherId) throws CustomException;

    void deleteStudent(Long id) throws CustomException;

    void deleteTeacher(Long id) throws CustomException;

    Teacher updateTeacher(Teacher teacher) throws CustomException;


    Student getStudentById(Long id) throws CustomException;

}
