package com.example.mahasiswarestapi.service;

import com.example.mahasiswarestapi.model.Mahasiswa;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @GET("posts/{id}")
    Call<Mahasiswa> getMahasiswa(@Path("id") int postId);

    @POST("mahasiswas")
    Call<Mahasiswa> createMahasiswa(@Body Mahasiswa post);

