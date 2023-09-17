package com.example.lab2_20192270;

import com.example.lab2_20192270.DTO.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TypicodeService {
    @GET("/api/")
    Call<Result> getResult();

}
