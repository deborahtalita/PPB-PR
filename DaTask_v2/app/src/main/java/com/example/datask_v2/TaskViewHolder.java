package com.example.datask_v2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class TaskViewHolder extends RecyclerView.ViewHolder{
    private final TextView taskNameView;
    private final TextView dueDateView;
    private final TextView courseNameView;
    LinearLayout layout;
    private TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        taskNameView = itemView.findViewById(R.id.view_name);
        dueDateView = itemView.findViewById(R.id.view_date);
        courseNameView = itemView.findViewById(R.id.view_course);
        layout = itemView.findViewById(R.id.linearLayout);
    }

    public void bind(String name, String date, String course) {
        taskNameView.setText(name);
        dueDateView.setText(date);
        courseNameView.setText(course);
    }

    static TaskViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tasklist_item, parent, false);
        return new TaskViewHolder(view);
    }
}
