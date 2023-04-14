package com.example.data_retreival;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    @GET("exec")
    Call<List<Model>> getPosts(
        @Query("action") String fxn,
        @Query("regno") String regno
    );
    @GET("exec")
    Call<summary> getSummary(
            @Query("action") String fxn
    );
    @FormUrlEncoded
    @POST("exec")
    Call<Delete> deletePost(
            @Query("action") String fxn,
            @Field("uniqueID") String uniqueID
    );
}
