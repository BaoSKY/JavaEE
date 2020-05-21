package com.mapper;

import com.model.Homework;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HomeworkMapper {

    @Insert("INSERT INTO homework (title, requirement) VALUES (#{title}, #{requirement})")
    boolean addHomework(String title, String requirement);

    @Select("SELECT * FROM homework")
    List<Homework> getAllHomework();

    @Select("SELECT * FROM homework WHERE title = #{title}")
    Homework getHomeworkByTitle(String title);

    @Select("SELECT h.id, h.title, h.requirement FROM homework h, assign a WHERE h.id = a.hid AND tid = #{tid}")
    List<Homework> getHomeworkOfTeacher(int tid);

    @Select("SELECT h.id, h.title, h.requirement FROM homework h, submit s WHERE h.id = s.hid AND sid = #{sid}")
    List<Homework> getHomeworkOfStudent(int sid);
}
