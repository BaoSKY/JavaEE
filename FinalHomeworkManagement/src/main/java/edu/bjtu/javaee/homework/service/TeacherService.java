package edu.bjtu.javaee.homework.service;

import edu.bjtu.javaee.homework.model.Teacher;

import java.util.List;

public interface TeacherService {

    boolean addTeacher(String name, String password);
    Teacher getTeacher(String name);
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(int id);
}
