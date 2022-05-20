package com.example.restfulapi.api;

import com.example.restfulapi.requests.BodyCreate;
import com.example.restfulapi.requests.BodyRegister;
import com.example.restfulapi.responses.CreateUserResponse;
import com.example.restfulapi.responses.RegisterResponse;
import com.example.restfulapi.responses.SingleResourceResponse;
import com.example.restfulapi.responses.SingleUserResponse;
import com.example.restfulapi.requests.BodyLogin;
import com.example.restfulapi.responses.ListResourceResponse;
import com.example.restfulapi.responses.ListUserResponse;
import com.example.restfulapi.responses.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MainInterface {

    @POST("api/login")
    Call<LoginResponse> postLogin(@Body BodyLogin bodyLogin);

    @GET("api/users?page=2")
    Call<ListUserResponse> getList();

    @GET("api/users/{id}")
    Call<SingleUserResponse> getUser(@Path("id") int userId);

    @GET("api/unknown")
    Call<ListResourceResponse> getListRsc();

    @POST("api/register")
    Call<RegisterResponse> postRegister(@Body BodyRegister bodyRegister);

    @GET("/api/unknown/{id}")
    Call<SingleResourceResponse> getResource(@Path("id") int userId);

    @POST("api/users")
    Call<CreateUserResponse> postUser(@Body BodyCreate bodyCreateUser);
}
