package com.example.datask_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class TaskDetailActivity extends AppCompatActivity {
    EditText tName, tDuedate, tCourse, tDesc;
    String name, duedate, course, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        tName = findViewById(R.id.detailName);
        tDuedate = findViewById(R.id.detailDate);
        tCourse = findViewById(R.id.detailCourse);
        tDesc = findViewById(R.id.detailDescription);

        Intent in = getIntent();
        name = in.getStringExtra("taskname");
        duedate = in.getStringExtra("duedate");
        course = in.getStringExtra("course");
        desc = in.getStringExtra("desc");

        tName.setText(name);
        tDuedate.setText(duedate);
        tCourse.setText(course);
        tDesc.setText(desc);
    }
}