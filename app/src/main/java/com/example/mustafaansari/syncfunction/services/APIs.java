package com.example.mustafaansari.syncfunction.services;

import com.example.mustafaansari.syncfunction.responses.ClusterResponse;
import com.example.mustafaansari.syncfunction.responses.UserResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIs {


    @GET("posts")
    Call<ResponseBody> getPosts();

    @GET("getclusters.php")
    Call<ResponseBody> getClusters();





}
