package com.example.datask_v2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class HomeFragment extends Fragment {
    private TaskViewModel mTaskViewModel;
    public static final int NEW_TASK_ACTIVITY_REQUEST_CODE = 1;

    private String txtName;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ImageButton plusButton = (ImageButton) view.findViewById(R.id.add_button);

        // welcome name
//        Bundle bundle = getArguments();
//        txtName = bundle.getString("name");
//        TextView welcomeName = view.findViewById(R.id.welcome);
//        String welcome = "Welcome, "+txtName;
//        welcomeName.setText(welcome);

        // recyclerview
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        final TaskListAdapter adapter = new TaskListAdapter(new TaskListAdapter.TaskDiff(), getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mTaskViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(TaskViewModel.class);
        mTaskViewModel.getAllTasks().observe(getViewLifecycleOwner(), tasks -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(tasks);
        });
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddNewTaskActivity.class);
                startActivityForResult(intent, NEW_TASK_ACTIVITY_REQUEST_CODE);
            }
        });
        return view;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_TASK_ACTIVITY_REQUEST_CODE && resultCode == -1) {
            Task task = new Task(data.getStringExtra("taskname"),data.getStringExtra("duedate"),data.getStringExtra("course"),data.getStringExtra("desc"));
            mTaskViewModel.insert(task);
        } else {
            Toast.makeText(
                    getActivity().getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}