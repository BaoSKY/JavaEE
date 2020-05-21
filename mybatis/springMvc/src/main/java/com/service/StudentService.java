package com.service;

import com.model.Student;

import java.util.List;

public interface StudentService {

    boolean addStudent(String name, String password);
    Student getStudent(String name);
    List<Student> getAllStudents();

}
