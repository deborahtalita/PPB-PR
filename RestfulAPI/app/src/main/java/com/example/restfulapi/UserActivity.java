package com.example.restfulapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {

    private DataItem item;
    private TextView textViewResult;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        textViewResult = findViewById(R.id.textViewResult);

        Intent in = new Intent();
        //id = in.getExtras().getInt("userId");
        getUser(2);

    }

    private void getUser(int userId){
        RestClient.getService().getUser(userId).enqueue((new Callback<SingleUserResponse>() {
            @Override
            public void onResponse(Call<SingleUserResponse> call, Response<SingleUserResponse> response) {
                if(response.isSuccessful()){
                    item = response.body().getData();
                    String content = "";
                    content += "ID: " + item.getId() + "\n";
                    content += "Email: " + item.getEmail() + "\n";
                    content += "First Name: " + item.getFirstName() + "\n";
                    content += "Last Name: " + item.getLastName() + "\n";
                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<SingleUserResponse> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        }));
    }
}