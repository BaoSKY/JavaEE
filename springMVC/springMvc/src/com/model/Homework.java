package com.model;

public class Homework {

    public static final int SUBMIT_STATUS_DOING = 0;
    public static final int SUBMIT_STATUS_SUBMITTED = 1;

    private int id;
    private String title;
    private String requirement;

    public Homework(){}

    public Homework(int id, String title, String requirement) {
        this.id = id;
        this.title = title;
        this.requirement = requirement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }
}
