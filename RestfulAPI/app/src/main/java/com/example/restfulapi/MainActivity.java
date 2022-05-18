package com.example.restfulapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.restfulapi.activities.ListResourceActivity;
import com.example.restfulapi.activities.ListUserActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btnListUser, btnListResource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnListUser = findViewById(R.id.btnListUser);
        btnListResource = findViewById(R.id.btnListRsc);

        View.OnClickListener onButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = null;
                switch(view.getId()){
                    case R.id.btnListUser:
                        in = new Intent(MainActivity.this, ListUserActivity.class);
                        break;
                    case R.id.btnListRsc:
                        in = new Intent(MainActivity.this, ListResourceActivity.class);
                        break;
                }
                startActivity(in);
            }
        };
        btnListUser.setOnClickListener(onButtonClickListener);
        btnListResource.setOnClickListener(onButtonClickListener);
    }
}