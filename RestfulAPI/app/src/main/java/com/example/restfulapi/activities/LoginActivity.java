package com.example.restfulapi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.restfulapi.responses.ErrorResponse;
import com.example.restfulapi.responses.ErrorUtils;
import com.example.restfulapi.responses.LoginResponse;
import com.example.restfulapi.MainActivity;
import com.example.restfulapi.R;
import com.example.restfulapi.api.RestClient;
import com.example.restfulapi.requests.BodyLogin;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText edtEmail;
    EditText edtPassword;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.tvUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BodyLogin bodyLogin = new BodyLogin();
                bodyLogin.setEmail(edtEmail.getText().toString());
                bodyLogin.setPassword(edtPassword.getText().toString());

                RestClient.getService().postLogin(bodyLogin).enqueue(new Callback<LoginResponse>() {
                    // method di bawah otomatis pada saat new Callback
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.isSuccessful()){
                            // Status code is 200
                            Toast.makeText(LoginActivity.this, response.body().getToken(), Toast.LENGTH_SHORT).show();
                            Log.i("Response", response.message());
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                        } else {
//                            ErrorResponse error = ErrorUtils.parseError(response);
//                            Toast.makeText(LoginActivity.this, error.getError(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(LoginActivity.this, "Code: " + response.code() + "\n" + "Missing password", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                    }
                });
            }
        });
    }
}