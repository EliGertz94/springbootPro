package com.example.springbootPro.service.impl;

import com.example.springbootPro.Exceptions.CustomException;
import com.example.springbootPro.entity.Student;
import com.example.springbootPro.entity.Teacher;
import com.example.springbootPro.repository.StudentRepository;
import com.example.springbootPro.repository.TeacherRepository;
import com.example.springbootPro.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;

    



    @Override
    public Teacher addTeacher(Teacher teacher) throws CustomException {
        if(!teacherRepository.existsByName(teacher.getName())) {

            Teacher savedTeacher = teacherRepository.save(teacher);

            return savedTeacher;
        }

        throw new CustomException("this name exists already use different one ",HttpStatus.BAD_REQUEST);
    }

    @Override
    public Student addStudent(Student student,Long teacherId) throws CustomException {

           Teacher teacher= teacherRepository.findById(teacherId).orElseThrow(
                   ()-> new CustomException("addStudent teacher not found", HttpStatus.BAD_REQUEST)
           );

           student.setTeacher(teacher);

        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) throws CustomException {

        Student student = studentRepository.findById(id).orElseThrow(
                ()-> new CustomException("deleteStudent not found by id", HttpStatus.BAD_REQUEST));

        studentRepository.delete(student);

    }

    @Override
    public void deleteTeacher(Long id) throws CustomException {

       Teacher teacher = teacherRepository.findById(id).orElseThrow(
                ()-> new CustomException("deleteStudent not found by id", HttpStatus.BAD_REQUEST));

        teacherRepository.delete(teacher);

    }

    //update the teacher not allowing us to update the id
    @Override
    public Teacher updateTeacher(Teacher teacher) throws CustomException {

       return  teacherRepository.findById(teacher.getId()).map(teacherEntity -> {
           teacherEntity.setAge(teacher.getAge());
           teacherEntity.setName(teacher.getName());
           teacherEntity.setSubject(teacher.getSubject());

           return teacherRepository.save(teacherEntity);
            }).orElseThrow(
               ()-> new CustomException("updateTeacher teacher not found", HttpStatus.BAD_REQUEST));
    }

    @Override
    public Student getStudentById(Long id) throws CustomException {
            Student student = studentRepository.findById(id).orElseThrow(
                    ()-> new CustomException("get student by id - not found ", HttpStatus.BAD_REQUEST));
            return  student;
    }
}
