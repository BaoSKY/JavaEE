package com.dao;

import com.model.Homework;

import java.util.List;

public interface HomeworkDao {

    boolean addHomework(String title, String requirement);
    List<Homework> getAllHomework();
    Homework getHomeworkByTitle(String title);
    List<Homework> getHomeworkOfTeacher(int tid);
    List<Homework> getHomeworkOfStudent(int sid);

}
