package com.example.datask_v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        EditText editName = new EditText(getContext());
        Button editBtn = view.findViewById(R.id.profile_btn);
        TextView profileName = view.findViewById(R.id.profile_name);

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog log = new AlertDialog.Builder(getContext())
                        .setCancelable(false)
                        .setTitle("Edit Name")
                        .setMessage("")
                        .setView(editName)
                        .setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String pName = String.valueOf(editName.getText());
                                profileName.setText(pName);
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                log.show();
//                String name = profileName.getText().toString();
//                Bundle bundle = new Bundle();
//                bundle.putString("name", name);
//                HomeFragment fragobj = new HomeFragment();
//                fragobj.setArguments(bundle);
//                getFragmentManager().beginTransaction().replace(R.id.main_container,fragobj).commit();
            }
        });
        return view;
    }
}