package com.example.evaluation;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class Holder  extends RecyclerView.ViewHolder {

    private TextView tvtille1,tvtittle2,tvdummy;
    private ImageView imageView;


    public Holder(@NonNull View itemView) {
        super(itemView);
        initviews(itemView);
    }

    private void initviews(View itemView) {
        imageView = itemView.findViewById(R.id.imageview);
        tvtille1 = itemView.findViewById(R.id.TvTittle1);
        tvtittle2 = itemView.findViewById(R.id.TvTittle2);
    }

    public void setData(ResponseModel responseModel) {
        tvtille1.setText(responseModel.getTitle());
        tvtittle2.setText(responseModel.getSubTitle());
        Glide.with(imageView).load(responseModel.getImage()).into(imageView);
    }
}
