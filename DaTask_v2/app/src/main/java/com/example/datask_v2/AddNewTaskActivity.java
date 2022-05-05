package com.example.datask_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddNewTaskActivity extends AppCompatActivity {

    private static final int JOB_ID = 0;
    private JobScheduler mScheduler;

    final Calendar myCalendar= Calendar.getInstance();
    private EditText taskName, courseName, datePicker, timePick, desc;
    Button addTaskBtn;
    int hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);
        getSupportActionBar().hide();
        taskName = findViewById(R.id.editTextName);
        datePicker = (EditText) findViewById(R.id.editTextDate);
        timePick = findViewById(R.id.editTextTime);
        courseName = findViewById(R.id.editTextCourse);
        desc = findViewById(R.id.editTextDescription);
        addTaskBtn = findViewById(R.id.addTaskButton);

        mScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

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

        timePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePicker();
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
                String time = timePick.getText().toString();
                Task thisTask = new Task(task_name, due_date, course, desc_msg, time);
                replyIntent.putExtra("TASK", thisTask);
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

    private void showTimePicker(){
        hour = myCalendar.get(Calendar.HOUR_OF_DAY);
        minute = myCalendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(AddNewTaskActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int h, int m) {
                timePick.setText(h + ":" + m);
            }
        }, hour, minute, true);
        timePickerDialog.show();
    }

    /**
     * onClick method that schedules the jobs based on the parameters set.
     */
    public void scheduleJob(View view) {

        ComponentName serviceName = new ComponentName(getPackageName(),
                NotificationJobService.class.getName());
        JobInfo.Builder builder = new JobInfo.Builder(JOB_ID, serviceName);

        JobInfo myJobInfo = builder.build();
        mScheduler.schedule(myJobInfo);
    }
}