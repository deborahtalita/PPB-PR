package com.example.restfulapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.restfulapi.activities.CRUDActivity;
import com.example.restfulapi.activities.ListResourceActivity;
import com.example.restfulapi.activities.ListUserActivity;
import com.example.restfulapi.activities.RegisterActivity;
import com.example.restfulapi.activities.SingleResourceActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btnListUser, btnListResource, btnRegister, btnSingleRsc, btnCRUD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnListUser = findViewById(R.id.btnListUser);
        btnListResource = findViewById(R.id.btnListRsc);
        btnRegister = findViewById(R.id.btnRegister);
        btnSingleRsc = findViewById(R.id.btnSingleRsc);
        btnCRUD = findViewById(R.id.btnCRUD);

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
                    case R.id.btnRegister:
                        in = new Intent(MainActivity.this, RegisterActivity.class);
                        break;
                    case R.id.btnSingleRsc:
                        in = new Intent(MainActivity.this, SingleResourceActivity.class);
                        break;
                    case R.id.btnCRUD:
                        in = new Intent(MainActivity.this, CRUDActivity.class);
                        break;
                }
                startActivity(in);
            }
        };
        btnListUser.setOnClickListener(onButtonClickListener);
        btnListResource.setOnClickListener(onButtonClickListener);
        btnRegister.setOnClickListener(onButtonClickListener);
        btnSingleRsc.setOnClickListener(onButtonClickListener);
        btnCRUD.setOnClickListener(onButtonClickListener);
    }
}