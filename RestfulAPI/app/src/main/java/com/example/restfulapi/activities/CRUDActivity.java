package com.example.restfulapi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.restfulapi.R;
import com.example.restfulapi.api.RestClient;
import com.example.restfulapi.requests.BodyCreate;
import com.example.restfulapi.responses.CreateUserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CRUDActivity extends AppCompatActivity {

    private CreateUserResponse createRespItem;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crudactivity);

        textViewResult = findViewById(R.id.textViewResult3);

        createUser("morpheus","leader");
    }

    private void createUser(String name, String job){
        BodyCreate bodyCreateUser = new BodyCreate();
        bodyCreateUser.setName(name);
        bodyCreateUser.setJob(job);

        RestClient.getService().postUser(bodyCreateUser).enqueue(new Callback<CreateUserResponse>() {
            @Override
            public void onResponse(Call<CreateUserResponse> call, Response<CreateUserResponse> response) {
                Log.i("Response", response.message());
                createRespItem = response.body();
                String content = "";
                content += "name: " + createRespItem.getName() + "\n";
                content += "job: " + createRespItem.getJob() + "\n";
                content += "id: " + createRespItem.getId() + "\n";
                content += "createdAt: " + createRespItem.getCreatedAt();
                textViewResult.append(content);
            }

            @Override
            public void onFailure(Call<CreateUserResponse> call, Throwable t) {
                textViewResult.setText(t.getMessage());

            }
        });
    }
}