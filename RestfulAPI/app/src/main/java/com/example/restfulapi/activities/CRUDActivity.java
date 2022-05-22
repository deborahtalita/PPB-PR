package com.example.restfulapi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.restfulapi.R;
import com.example.restfulapi.api.MainInterface;
import com.example.restfulapi.api.RestClient;
import com.example.restfulapi.requests.BodyCreate;
import com.example.restfulapi.responses.CreateUserResponse;
import com.example.restfulapi.responses.UpdateUserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CRUDActivity extends AppCompatActivity {

    private UpdateUserResponse updateRespItem;
    private CreateUserResponse createRespItem;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crudactivity);

        textViewResult = findViewById(R.id.textViewResult3);

        // createUser("morpheus", "leader");
        // updateUser(2, "morpheus", "zion resident");
        deleteUser(2);
    }

    private void createUser(String name, String job) {
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

    private void updateUser(int id, String name, String job) {
        BodyCreate bodyUpdateUser = new BodyCreate();
        bodyUpdateUser.setName(name);
        bodyUpdateUser.setJob(job);

        // PATCH request
        RestClient.getService().patchUser(id, bodyUpdateUser).enqueue(new Callback<UpdateUserResponse>() {

        // PUT request
        //RestClient.getService().putUser(id, bodyUpdateUser).enqueue(new Callback<UpdateUserResponse>() {
            @Override
            public void onResponse(Call<UpdateUserResponse> call, Response<UpdateUserResponse> response) {
                Log.i("Response", response.message());
                updateRespItem = response.body();
                String content = "";
                content += "name: " + updateRespItem.getName() + "\n";
                content += "job: " + updateRespItem.getJob() + "\n";
                content += "updatedAt: " + updateRespItem.getUpdatedAt();
                textViewResult.append(content);
            }

            @Override
            public void onFailure(Call<UpdateUserResponse> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    private void deleteUser(int id){
        RestClient.getService().deleteUser(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                textViewResult.setText("Code: " + response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}