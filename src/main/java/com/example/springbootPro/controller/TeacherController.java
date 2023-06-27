package com.example.springbootPro.controller;

import com.example.springbootPro.Exceptions.CustomException;
import com.example.springbootPro.entity.DTO.StudentRequest;
import com.example.springbootPro.entity.DTO.TeacherRequest;
import com.example.springbootPro.entity.Student;
import com.example.springbootPro.entity.Teacher;
import com.example.springbootPro.entity.User;
import com.example.springbootPro.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/teacher/")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @PostMapping("add-teacher")
    public ResponseEntity<?> saveTeacher(@RequestBody TeacherRequest teacher){

        User userEntity = User.builder()
                .id(0L)
                .username(teacher.getUsername())
                .password(teacher.getPassword())
                .build();

        Teacher teacherEntity =  Teacher.builder()
                .id(0L)
                .age(teacher.getAge())
                .name(teacher.getName())
                .subject(teacher.getSubject())
                .user(userEntity)
                .build();


        try{
            return new ResponseEntity<>(teacherService.addTeacher(teacherEntity,userEntity), HttpStatus.OK);
        }catch (CustomException e){
            return new ResponseEntity<>(e.getMessage(),e.getHttpStatus());
        }

    }


    @PostMapping("add-student")
    public ResponseEntity<?> saveStudent(@RequestBody StudentRequest student){

       Student studentEntity = Student.builder()
               .age(student.getAge())
               .id(0L)
               .name(student.getName())
               .build();

        try{
            return new ResponseEntity<>(teacherService.addStudent(studentEntity, student.getTeacherId()), HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(e.getMessage(),e.getHttpStatus());
        }
    }

    @DeleteMapping("delete-student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        try{
            teacherService.deleteStudent(id);
            return new ResponseEntity<>("student with id " +id+ " was removed" ,HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(e.getMessage(),e.getHttpStatus());
        }
    }
    @PutMapping("update-teacher")
    public ResponseEntity<?>  updateTeacher(@RequestBody Teacher teacher){
        try{
            Teacher teacherEntity =teacherService.updateTeacher(teacher);
            return new ResponseEntity<>(teacherEntity,HttpStatus.OK);


        }catch (CustomException e){
            return new ResponseEntity<>(e.getMessage(),e.getHttpStatus());

        }

    }


}
