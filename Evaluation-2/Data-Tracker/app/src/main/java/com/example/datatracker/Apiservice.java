package com.example.datatracker;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Apiservice {

    @GET("v1/us/daily.json")
    Call<List<ResponseModel>> getPost();
}
