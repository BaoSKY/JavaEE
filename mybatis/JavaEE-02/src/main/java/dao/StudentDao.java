package dao;

import model.Student;

import java.util.List;

public interface StudentDao {

    boolean addStudent(String name, String password);
    Student getStudent(String name);
    List<Student> getAllStudents();

}
