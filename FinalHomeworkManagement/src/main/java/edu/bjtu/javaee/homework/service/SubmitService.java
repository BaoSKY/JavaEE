package edu.bjtu.javaee.homework.service;

import edu.bjtu.javaee.homework.model.Submit;

import java.util.List;

public interface SubmitService {

    void addSubmit(int sid, int hid);
    void submit(int sid, int hid, String content);
    String getContent(int sid, int hid);
    List<Submit> getSubmitByHid(int hid);
}
