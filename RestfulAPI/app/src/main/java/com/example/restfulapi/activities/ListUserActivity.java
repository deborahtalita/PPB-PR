package com.example.restfulapi.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.restfulapi.responses.DataItem;
import com.example.restfulapi.adapter.ListUserAdapter;
import com.example.restfulapi.responses.ListUserResponse;
import com.example.restfulapi.R;
import com.example.restfulapi.api.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListUserActivity extends AppCompatActivity {
    RecyclerView rvListUser;
    private List<DataItem> listItem;
    private ListUserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        rvListUser = findViewById(R.id.rvListUser);

        //getListUser();
        getListUserDelayed();
    }

    private void getListUser(){
        RestClient.getService().getList().enqueue(new Callback<ListUserResponse>() {
            @Override
            public void onResponse(Call<ListUserResponse> call, Response<ListUserResponse> response) {
                if (response.isSuccessful()){
                    listItem = response.body().getData();

                    adapter = new ListUserAdapter(listItem, ListUserActivity.this);
                    rvListUser.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rvListUser.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ListUserResponse> call, Throwable t) {

            }
        });
    }

    private void getListUserDelayed(){
        RestClient.getService().delayedResponse().enqueue(new Callback<ListUserResponse>() {
            @Override
            public void onResponse(Call<ListUserResponse> call, Response<ListUserResponse> response) {
                if (response.isSuccessful()){
                    listItem = response.body().getData();

                    adapter = new ListUserAdapter(listItem, ListUserActivity.this);
                    rvListUser.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rvListUser.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ListUserResponse> call, Throwable t) {

            }
        });
    }
}