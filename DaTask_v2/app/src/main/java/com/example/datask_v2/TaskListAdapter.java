package com.example.datask_v2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskListAdapter extends
        ListAdapter<Task, TaskViewHolder> {

    Context ctx;
    protected TaskListAdapter(@NonNull DiffUtil.ItemCallback<Task> diffCallback, Context ctx) {
        super(diffCallback);
        this.ctx = ctx;

    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return TaskViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task current = getItem(position);
        holder.bind(current.getTaskName(), current.getDueDate(), current.getCourseName());
        holder.layout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent in = new Intent(ctx, TaskDetailActivity.class);
                Task task = new Task(current.getTaskName(), current.getDueDate(), current.getCourseName(), current.getDesc(), current.getTime());
                in.putExtra("TASK", task);
                ctx.startActivity(in);
            }
        });

    }

    static class TaskDiff extends DiffUtil.ItemCallback<Task> {

        @Override
        public boolean areItemsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem.getTaskName().equals(newItem.getTaskName());
        }
    }
}

