package edu.bjtu.javaee.homework.service;

import edu.bjtu.javaee.homework.model.Homework;

import java.util.List;

public interface HomeworkService {

    boolean addHomework(String title, String requirement);
    List<Homework> getAllHomework();
    Homework getHomeworkByTitle(String title);
    List<Homework> getHomeworkOfTeacher(int tid);
    List<Homework> getHomeworkOfStudent(int sid);
    Homework getHomeworkById(int hid);
}
