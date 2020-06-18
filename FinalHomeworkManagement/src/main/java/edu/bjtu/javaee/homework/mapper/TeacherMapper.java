package edu.bjtu.javaee.homework.mapper;

import edu.bjtu.javaee.homework.model.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

    @Insert("INSERT INTO teacher (name, password) VALUES (#{name}, #{password})")
    boolean addTeacher(String name, String password);

    @Select("SELECT * FROM teacher WHERE name= #{name}")
    Teacher getTeacher(String name);

    @Select("SELECT * FROM teacher WHERE id= #{id}")
    Teacher getTeacherById(int id);

    @Select("SELECT * FROM teacher")
    List<Teacher> getAllTeachers();
}
