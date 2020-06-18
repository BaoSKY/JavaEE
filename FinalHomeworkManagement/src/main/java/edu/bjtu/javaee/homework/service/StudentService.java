package edu.bjtu.javaee.homework.service;

import edu.bjtu.javaee.homework.model.Student;

import java.util.List;

public interface StudentService {

    boolean addStudent(String name, String password);
    Student getStudent(String name);
    List<Student> getAllStudents();

}
