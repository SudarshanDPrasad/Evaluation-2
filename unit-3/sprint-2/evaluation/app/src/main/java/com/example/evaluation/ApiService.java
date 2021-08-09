package com.example.evaluation;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("{userName}/{userId}/{raw}/{id}/{brokerName}")
    Call<ArrayList<ResponseModel>> data (@Path("userName") String userName,
                                         @Path("userId") String userId,
                                         @Path("raw") String raw,
                                         @Path("id") String id,
                                         @Path("brokerName") String brokerName);

}
