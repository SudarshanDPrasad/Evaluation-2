package com.example.evaluation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BlankFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<ResponseModel> responseModels = new ArrayList<>();
    private Adaptor adaptor;
    private TextView tv2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initviews(view);

    }

    private void setRecycler() {
        adaptor = new Adaptor(responseModels);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adaptor);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void initviews(View view) {
        recyclerView = view.findViewById(R.id.recyclerview);
        tv2 = view.findViewById(R.id.tv2);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dilaydata();
                setRecycler();
            }
        });
    }
    private void dilaydata() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        Call<ArrayList<ResponseModel>> call = apiService.data("shivarajp",
                "2cbe00030c04472c9d8ad4b0ec112dbe", "raw",
                "c651391e428182f08d60d59e79073f3fcf79b858", "nobroker");
        call.enqueue(new Callback<ArrayList<ResponseModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseModel>> call, Response<ArrayList<ResponseModel>> response) {
                responseModels = response.body();
                adaptor.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ArrayList<ResponseModel>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}