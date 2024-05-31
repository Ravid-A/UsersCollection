package com.example.userscollection.user;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserService {
    @GET("/api")
    public Call<UserResponse> getUser(
            @Query("limit") Integer limit,
            @Query("skip") Integer skip,
            @Query("select") String select
    );
}
