package com.dao;

import com.model.Teacher;

import java.util.List;

public interface TeacherDao {

    boolean addTeacher(String name, String password);
    Teacher getTeacher(String name);
    List<Teacher> getAllTeachers();
}
