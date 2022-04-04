package com.example.datask_v2;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_table")
public class Task {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "taskName")
    private String taskName;

    @ColumnInfo(name = "duedate")
    private String dueDate;

    @ColumnInfo(name = "courseName")
    private String courseName;

    @ColumnInfo(name = "desc")
    private String desc;

    public Task(@NonNull String taskName, String dueDate, String courseName, String desc) {
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.courseName = courseName;
        this.desc = desc;
    }

    public String getTaskName(){
        return this.taskName;
    }

    public String getDueDate(){
        return this.dueDate;
    }

    public String getCourseName(){
        return this.courseName;
    }
    public String getDesc(){
        return this.desc;
    }
}

