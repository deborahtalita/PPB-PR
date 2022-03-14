package com.example.datask;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TaskListAdapter extends
        RecyclerView.Adapter<TaskListAdapter.ViewHolder>{

    Context ctx;
    private LayoutInflater mInflater;
    String[] dataName;
    String[] dataDate;
    String[] dataCourse;
    String[] dataDesc;

    public TaskListAdapter(Context ctx, String[] d1,String[] d2, String[] d3){
        mInflater = LayoutInflater.from(ctx);
        dataName = d1;
        dataDate = d2;
        dataCourse = d3;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View taskView = mInflater.inflate(R.layout.tasklist_item, viewGroup, false);
        ViewHolder vHolder = new ViewHolder(taskView);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, @SuppressLint("RecyclerView") int i) {
        viewHolder.taskName.setText(dataName[i]);
        viewHolder.dueDate.setText(dataDate[i]);
        viewHolder.courseName.setText(dataCourse[i]);
        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(ctx, TaskDetailActivity.class);
                in.putExtra("taskname",dataName[i]);
                in.putExtra("duedate",dataDate[i]);
                in.putExtra("course",dataCourse[i]);
                in.putExtra("desc",dataDesc[i]);
                ctx.startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataName.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView taskName, dueDate, courseName;
        LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            taskName = itemView.findViewById(R.id.view_name);
            dueDate = itemView.findViewById(R.id.view_date);
            courseName = itemView.findViewById(R.id.view_course);
            layout = itemView.findViewById(R.id.layoutHolder);
        }
    }
}
