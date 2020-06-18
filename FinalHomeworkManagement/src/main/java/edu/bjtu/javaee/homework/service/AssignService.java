package edu.bjtu.javaee.homework.service;

import java.util.List;

public interface AssignService {

    void assign(int tid, int hid);
    List<Integer> getHomeworkIdList(int tid);
}
