package com.example.datask_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ReminderActivity extends AppCompatActivity {

    private static final int JOB_ID = 0;
    private JobScheduler mScheduler;
    private Button startBtn, stopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        getSupportActionBar().hide();

        startBtn = findViewById(R.id.startSched_btn);
        stopBtn = findViewById(R.id.stopSched_btn);

        mScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isJobSchedulerRunning()){
                    Log.i("ReminderActivity","start scheduler");
                    scheduleJob(view);
                } else {
                    Log.i("ReminderActivity","job scheduler is already running");
                    Toast.makeText(getApplicationContext(), "Daily Reminder is already activated!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isJobSchedulerRunning()){
                    Log.i("ReminderActivity","stop scheduler");
                    cancelJobs(view);
                } else {
                    Log.i("ReminderActivity","there's no running job scheduler");
                    Toast.makeText(getApplicationContext(), "Activate First!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

        /**
     * onClick method that schedules the jobs based on the parameters set.
     */
    public void scheduleJob(View view) {
        ComponentName serviceName = new ComponentName(this,
                NotificationJobService.class.getName());
        JobInfo.Builder builder = new JobInfo.Builder(JOB_ID, serviceName)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setPersisted(true)
                .setPeriodic(24*60*60*1000); // 24 jam

        JobInfo myJobInfo = builder.build();
        mScheduler.schedule(myJobInfo);
        Toast.makeText(this, "Daily Reminder is now active!", Toast.LENGTH_SHORT).show();
    }

    public void cancelJobs(View view){
        mScheduler.cancelAll();
        Toast.makeText(this, "Daily reminder is stopped", Toast.LENGTH_SHORT).show();
    }

    public boolean isJobSchedulerRunning() {
        for(JobInfo jobInfo : mScheduler.getAllPendingJobs()){
            if(jobInfo.getId() == JOB_ID){
                return true;
            }
        }
        return false;
    }
}