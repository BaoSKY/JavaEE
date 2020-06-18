package edu.bjtu.javaee.homework.mapper;

import edu.bjtu.javaee.homework.model.Submit;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SubmitMapper {

    @Insert("INSERT INTO submit (sid, hid, status) VALUES (#{sid}, #{hid}, #{status})")
    void addSubmit(int sid, int hid, int status);

    @Update("UPDATE submit SET status = #{status}, content = #{content}, submit_time = now() WHERE sid = #{sid} AND hid = #{hid}")
    void submit(int sid, int hid, int status, String content);

    @Select("SELECT content FROM submit WHERE sid = #{sid} AND hid = #{hid}")
    String getContent(int sid, int hid);

    @Select("SELECT * FROM submit WHERE hid = #{hid}")
    List<Submit> getSubmitByHid(int hid);
}
