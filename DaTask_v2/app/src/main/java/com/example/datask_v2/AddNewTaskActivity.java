package com.example.datask_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddNewTaskActivity extends AppCompatActivity {

    final Calendar myCalendar= Calendar.getInstance();
    private EditText taskName;
    private EditText courseName;
    private EditText desc;
    private EditText datePicker;
    Button addTaskBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);
        getSupportActionBar().hide();
        taskName = findViewById(R.id.editTextName);
        datePicker = (EditText) findViewById(R.id.editTextDate);
        courseName = findViewById(R.id.editTextCourse);
        desc = findViewById(R.id.editTextDescription);
        addTaskBtn = findViewById(R.id.addTaskButton);

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, day);
                updateLabel();
            }
        };
        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(AddNewTaskActivity.this, date, myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        addTaskBtn.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if(TextUtils.isEmpty(taskName.getText())){
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String task_name = taskName.getText().toString();
                String due_date = datePicker.getText().toString();
                String course = courseName.getText().toString();
                String desc_msg = desc.getText().toString();
                replyIntent.putExtra("taskname",task_name);
                replyIntent.putExtra("duedate",due_date);
                replyIntent.putExtra("course",course);
                replyIntent.putExtra("desc",desc_msg);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }

    private void updateLabel(){
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        datePicker.setText(dateFormat.format(myCalendar.getTime()));
    }
}