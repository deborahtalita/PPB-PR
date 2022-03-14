package com.example.datask;

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
    private List<Task> listTask;
    private LayoutInflater mInflater;

    public TaskListAdapter(Context ctx, List<Task> listTask){
        mInflater = LayoutInflater.from(ctx);
        this.listTask = listTask;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View taskView = mInflater.inflate(R.layout.tasklist_item, viewGroup, false);
        ViewHolder vHolder = new ViewHolder(taskView);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Task item = listTask.get(i);
        viewHolder.taskName.setText(listTask.get(i).getName());
        viewHolder.dueDate.setText(listTask.get(i).getDueDate());
        viewHolder.courseName.setText(listTask.get(i).getCourse());
    }

    @Override
    public int getItemCount() {

        return listTask.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView taskName, dueDate, courseName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            taskName = itemView.findViewById(R.id.view_name);
            dueDate = itemView.findViewById(R.id.view_date);
            courseName = itemView.findViewById(R.id.view_course);
        }
    }
}