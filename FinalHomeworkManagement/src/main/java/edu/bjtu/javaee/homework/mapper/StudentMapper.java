package edu.bjtu.javaee.homework.mapper;

import edu.bjtu.javaee.homework.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    @Insert("INSERT INTO student (name, password) VALUES (#{name}, #{password})")
    boolean addStudent(String name, String password);

    @Select("SELECT * FROM student WHERE name=#{name}")
    Student getStudent(String name);

    @Select("SELECT * FROM student")
    List<Student> getAllStudents();
}
