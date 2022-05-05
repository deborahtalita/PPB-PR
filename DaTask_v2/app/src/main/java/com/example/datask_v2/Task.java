package com.example.datask_v2;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_table")
public class Task implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "taskName")
    @NonNull
    private String taskName;

    @ColumnInfo(name = "duedate")
    private String dueDate;

    @ColumnInfo(name = "time")
    private String time;

    @ColumnInfo(name = "courseName")
    private String courseName;

    @ColumnInfo(name = "desc")
    private String desc;

    public Task(@NonNull String taskName, String dueDate, String courseName, String desc, String time) {
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.courseName = courseName;
        this.desc = desc;
        this.time = time;
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
    public String getTime() {
        return time;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(taskName);
        parcel.writeString(dueDate);
        parcel.writeString(courseName);
        parcel.writeString(desc);
        parcel.writeString(time);
    }

    protected Task (Parcel in){
        id = in.readInt();
        taskName = in.readString();
        dueDate = in.readString();
        courseName = in.readString();
        desc = in.readString();
        time = in.readString();
    }

    public static final Parcelable.Creator<Task> CREATOR = new Parcelable.Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel source) {
            return new Task(source);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };
}

