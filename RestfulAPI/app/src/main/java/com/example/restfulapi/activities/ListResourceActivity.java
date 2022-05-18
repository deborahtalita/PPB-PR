package com.example.restfulapi.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.restfulapi.R;
import com.example.restfulapi.api.RestClient;
import com.example.restfulapi.adapter.ListResourceAdapter;
import com.example.restfulapi.responses.DataResourceItem;
import com.example.restfulapi.responses.ListResourceResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListResourceActivity extends AppCompatActivity {
    RecyclerView rvListRsc;
    private List<DataResourceItem> listItem;
    private ListResourceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_resource);

        rvListRsc = findViewById(R.id.rvListRsc);

        getListResource();
    }

    private void getListResource(){
        RestClient.getService().getListRsc().enqueue(new Callback<ListResourceResponse>() {
            @Override
            public void onResponse(Call<ListResourceResponse> call, Response<ListResourceResponse> response) {
                if (response.isSuccessful()){
                    listItem = response.body().getData();

                    adapter = new ListResourceAdapter(listItem, ListResourceActivity.this);
                    rvListRsc.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rvListRsc.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ListResourceResponse> call, Throwable t) {

            }
        });
    }
}