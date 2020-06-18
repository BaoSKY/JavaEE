package edu.bjtu.javaee.homework.model;

import java.util.Date;

public class Submit {

    private int sid;
    private int hid;
    private int status;
    private String content;
    private Date submit_time;

    public Submit(int sid, int hid, int status, String content, Date submit_time) {
        this.sid = sid;
        this.hid = hid;
        this.status = status;
        this.content = content;
        this.submit_time = submit_time;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSubmit_time() {
        return submit_time;
    }

    public void setSubmit_time(Date submit_time) {
        this.submit_time = submit_time;
    }
}
