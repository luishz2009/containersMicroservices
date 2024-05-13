package com.microservice.student.service;

import com.microservice.student.entity.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();

    Student findById(Long id);

    void save(Student student);

    List<Student> findByIdCourse(Long idCourse);

    void deleteById(Long id);
}