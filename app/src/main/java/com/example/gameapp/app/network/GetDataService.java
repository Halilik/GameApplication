package com.example.gameapp.app.network;

import com.example.gameapp.app.model.GamePojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;



public interface GetDataService {

    @GET("/games")
    Call<List<GamePojo>> getAllPhotos();
}
