package com.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface SubmitMapper {

    @Insert("INSERT INTO submit (sid, hid, status) VALUES (#{sid}, #{hid}, #{status})")
    void addSubmit(int sid, int hid, int status);

    @Update("UPDATE submit SET status = #{status}, content = #{content}, submit_time = now() WHERE sid = #{sid} AND hid = #{hid}")
    void submit(int sid, int hid, int status, String content);
}
