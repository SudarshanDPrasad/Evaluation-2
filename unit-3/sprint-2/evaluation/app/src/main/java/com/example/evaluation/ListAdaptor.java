package com.example.evaluation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdaptor extends RecyclerView.Adapter<ListHolder> {

    private List<ResponseModel> responseModelList;

    public ListAdaptor(List<ResponseModel> responseModelList) {
        this.responseModelList = responseModelList;
    }

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_list, parent, false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHolder holder, int position) {
        ResponseModel responseModel = responseModelList.get(position);
        holder.setData(responseModel);
    }

    @Override
    public int getItemCount() {
        return responseModelList.size();
    }
}
