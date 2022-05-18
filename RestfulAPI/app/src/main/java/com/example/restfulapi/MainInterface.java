package com.example.restfulapi;

import com.example.restfulapi.responses.ListResourceResponse;

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
}
