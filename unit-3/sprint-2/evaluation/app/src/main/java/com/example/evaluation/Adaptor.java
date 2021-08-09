package com.example.evaluation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptor extends RecyclerView.Adapter<Holder> {

    private List<ResponseModel> responseModelList;

    public Adaptor(List<ResponseModel> responseModelList) {
        this.responseModelList = responseModelList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout2, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        ResponseModel responseModel = responseModelList.get(position);
        holder.setData(responseModel);
    }


    @Override
    public int getItemCount() {
        return responseModelList.size();
    }
}
