package com.service;

public interface SubmitService {

    void addSubmit(int sid, int hid);
    void submit(int sid, int hid, String content);
}
