package com.mapper;

import org.apache.ibatis.annotations.Insert;

public interface AssignMapper {

    @Insert("INSERT INTO assign (tid, hid) VALUES (#{tid}, #{hid})")
    void assign(int tid, int hid);
}
