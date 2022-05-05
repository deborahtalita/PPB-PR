package com.example.datask_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class TaskDetailActivity extends AppCompatActivity {
    EditText tName, tDuedate, tCourse, tDesc, tTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        getSupportActionBar().hide();
        tName = findViewById(R.id.detailName);
        tDuedate = findViewById(R.id.detailDate);
        tTime= findViewById(R.id.detailTime);
        tCourse = findViewById(R.id.detailCourse);
        tDesc = findViewById(R.id.detailDescription);

        Intent in = getIntent();
        Task thisTask = in.getParcelableExtra("TASK");

        tName.setText(thisTask.getTaskName());
        tDuedate.setText(thisTask.getDueDate());
        tTime.setText(thisTask.getTime());
        tCourse.setText(thisTask.getCourseName());
        tDesc.setText(thisTask.getDesc());
    }
}