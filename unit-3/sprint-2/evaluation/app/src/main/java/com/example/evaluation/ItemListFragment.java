package com.example.evaluation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import retrofit2.Call;


public class ItemListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<ResponseModel> responseModels = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initviews(view);
        setRecycler();
    }

    private void setRecycler() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        Call<ArrayList<ResponseModel>> call = apiService.data("shivarajp",
                "2cbe00030c04472c9d8ad4b0ec112dbe","raw",
                "c651391e428182f08d60d59e79073f3fcf79b858","nobroker");
    }

    private void initviews(View view) {
        recyclerView = view.findViewById(R.id.recyclerview);
    }
}