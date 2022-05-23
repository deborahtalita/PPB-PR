package com.example.restfulapi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.restfulapi.MainActivity;
import com.example.restfulapi.R;
import com.example.restfulapi.api.RestClient;
import com.example.restfulapi.requests.BodyLogin;
import com.example.restfulapi.requests.BodyRegister;
import com.example.restfulapi.responses.ErrorResponse;
import com.example.restfulapi.responses.ErrorUtils;
import com.example.restfulapi.responses.LoginResponse;
import com.example.restfulapi.responses.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText edtEmail;
    EditText edtPassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtEmail = findViewById(R.id.tvUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnRegister = findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BodyRegister bodyRegister = new BodyRegister();
                bodyRegister.setEmail(edtEmail.getText().toString());
                bodyRegister.setPassword(edtPassword.getText().toString());

                RestClient.getService().postRegister(bodyRegister).enqueue(new Callback<RegisterResponse>() {
                    // method di bawah otomatis pada saat new Callback
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        if (response.isSuccessful()){
                            // Status code is 200
                            Toast.makeText(RegisterActivity.this,
                                    "id: " + response.body().getId() + "\n" +
                                    "token: " + response.body().getToken(),
                                    Toast.LENGTH_SHORT).show();
                            Log.i("Response", response.message());
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                        } else {
//                            ErrorResponse error = ErrorUtils.parseError(response);
//                            Toast.makeText(RegisterActivity.this, error.getError(), Toast.LENGTH_SHORT).show();

                            Toast.makeText(RegisterActivity.this, "Missing password", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {

                    }
                });
            }
        });
    }
}