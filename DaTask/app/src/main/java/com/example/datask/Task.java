package com.example.datask;

public class Task {
    private String name;
    private String dueDate;
    private String course;
    private String desc;

    public Task(String n, String d, String c, String dsc){
        n = name;
        d = dueDate;
        c = course;
        dsc =desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
