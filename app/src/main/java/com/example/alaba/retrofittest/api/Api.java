package com.example.alaba.retrofittest.api;

import com.example.alaba.retrofittest.models.DefaultResponse;
import com.example.alaba.retrofittest.models.LoginResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("sample.php")
    Call<DefaultResponse> createUser(
        @Field("email") String email,
        @Field("password") String password
    );

    @FormUrlEncoded
    @POST("userLogin.php")
    Call<LoginResponse> userLogin(
        @Field("email") String email,
        @Field("password") String password
    );
}
