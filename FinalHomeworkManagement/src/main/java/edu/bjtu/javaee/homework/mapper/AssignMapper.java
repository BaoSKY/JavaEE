package edu.bjtu.javaee.homework.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AssignMapper {

    @Insert("INSERT INTO assign (tid, hid) VALUES (#{tid}, #{hid})")
    void assign(int tid, int hid);

    @Select("SELECT hid FROM assign WHERE tid = #{tid}")
    List<Integer> getHomeworkIdList(int tid);
}
