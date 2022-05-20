package com.example.restfulapi.responses;

import com.google.gson.annotations.SerializedName;

public class SingleResourceResponse {
    @SerializedName("data")
    private DataResourceItem data;

    @SerializedName("support")
    private Support support;

    public void setData(DataResourceItem data){
        this.data = data;
    }

    public DataResourceItem getData(){
        return data;
    }

    public void setSupport(Support support){
        this.support = support;
    }

    public Support getSupport(){
        return support;
    }

    @Override
    public String toString(){
        return
                "SingleUserResponse{" +
                        "data = '" + data + '\'' +
                        ",support = '" + support + '\'' +
                        "}";
    }

}
