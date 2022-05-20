package com.example.restfulapi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.restfulapi.R;
import com.example.restfulapi.api.RestClient;
import com.example.restfulapi.responses.DataItem;
import com.example.restfulapi.responses.DataResourceItem;
import com.example.restfulapi.responses.SingleResourceResponse;
import com.example.restfulapi.responses.SingleUserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingleResourceActivity extends AppCompatActivity {

    private DataResourceItem item;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_resource);

        textViewResult = findViewById(R.id.textViewResult2);
        getResource(2);
        // getResource(23);
    }

    private void getResource(int userId){
        RestClient.getService().getResource(userId).enqueue((new Callback<SingleResourceResponse>() {
            @Override
            public void onResponse(Call<SingleResourceResponse> call, Response<SingleResourceResponse> response) {
                if(response.isSuccessful()){
                    item = response.body().getData();
                    String content = "";
                    content += "ID: " + item.getId() + "\n";
                    content += "Name: " + item.getName() + "\n";
                    content += "Year: " + item.getYear() + "\n";
                    content += "Color: " + item.getPantoneValue() + "\n";
                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<SingleResourceResponse> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        }));
    }
}