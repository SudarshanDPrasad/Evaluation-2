package com.example.datatracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class dataAdaptor extends RecyclerView.Adapter<DataViewHolder> {

    private List<ResponseModel> responseModelList;
    private OnLongClick onLongClick;

    public dataAdaptor(List<ResponseModel> responseModelList,OnLongClick onLongClick) {
        this.responseModelList = responseModelList;
        this.onLongClick = onLongClick;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        ResponseModel responseModel = responseModelList.get(position);
        holder.setData(responseModel,onLongClick);

    }

    @Override
    public int getItemCount() {
        return responseModelList.size();
    }

    public void updtate(List<ResponseModel> responseModelList) {
        this.responseModelList = responseModelList;
        notifyDataSetChanged();
    }
}
