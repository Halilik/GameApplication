package com.example.gameapp.app.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.example.gameapp.app.R;
import com.example.gameapp.app.adapter.CustomAdapter;
import com.example.gameapp.app.model.GamePojo;
import com.example.gameapp.app.network.GetDataService;
import com.example.gameapp.app.network.RetrofitClientInstance;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameRecyclerActivity extends AppCompatActivity {

    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_activity);

        progressDoalog = new ProgressDialog(GameRecyclerActivity.this);
        progressDoalog.setMessage("Loading...");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        Call<List<GamePojo>> call = service.getAllPhotos();

        call.enqueue(new Callback<List<GamePojo>>() {


            @Override
            public void onResponse(Call<List<GamePojo>> call, Response<List<GamePojo>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<GamePojo>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(GameRecyclerActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });



    }



    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<GamePojo> photoList) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new CustomAdapter(this,photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(GameRecyclerActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }




}
