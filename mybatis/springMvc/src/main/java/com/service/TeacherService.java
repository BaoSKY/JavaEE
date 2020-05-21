package com.service;

import com.model.Teacher;

import java.util.List;

public interface TeacherService {

    boolean addTeacher(String name, String password);
    Teacher getTeacher(String name);
    List<Teacher> getAllTeachers();
}
