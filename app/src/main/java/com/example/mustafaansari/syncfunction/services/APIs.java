package com.example.mustafaansari.syncfunction.services;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIs {


    @GET("posts")
    Call<ResponseBody> getPosts();



}
