package com.example.restfulapi.responses;

import com.google.gson.annotations.SerializedName;

public class UpdateUserResponse{

	@SerializedName("name")
	private String name;

	@SerializedName("job")
	private String job;

	@SerializedName("updatedAt")
	private String updatedAt;

	public String getName(){
		return name;
	}

	public String getJob(){
		return job;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}
}