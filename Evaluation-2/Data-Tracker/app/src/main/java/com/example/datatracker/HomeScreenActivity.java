package com.example.datatracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeScreenActivity extends AppCompatActivity implements OnLongClick {

    private RecyclerView recyclerView;
    private List<ResponseModel> responseModelList = new ArrayList<>();
    private dataAdaptor dataAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        initviews();
        CallApi();
        setRecyclerView();
    }

    private void initviews() {
        recyclerView = findViewById(R.id.recyclerview);
    }

    private void CallApi() {
        Apiservice apiservice = Network.getInstance().create(Apiservice.class);
        apiservice.getPost().enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {

                    responseModelList = response.body();
                    dataAdaptor.updtate(responseModelList);

            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {

            }
        });
    }

    private void setRecyclerView() {
        dataAdaptor = new dataAdaptor(responseModelList,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(dataAdaptor);
    }

    @Override
    public void OnClick(ResponseModel responseModel) {


        Intent intent = new Intent();
        intent.setAction("android.content.Intent.ACTION_SEND");
        intent.putExtra("username", "https://www.masaischool.com");


        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(HomeScreenActivity.this, "Not Found", Toast.LENGTH_SHORT).show();
        }

        dataAdaptor.updtate(responseModelList);
    }

    @Override
    public void remove(ResponseModel responseModel) {
        responseModelList.remove(responseModel);
        dataAdaptor.updtate(responseModelList);
    }

}