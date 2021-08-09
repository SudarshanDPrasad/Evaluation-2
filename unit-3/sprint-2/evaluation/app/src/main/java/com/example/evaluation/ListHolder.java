package com.example.evaluation;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ListHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView tvTittle,tvSubTittl;



    public ListHolder(@NonNull View itemView) {
        super(itemView);
        initviews(itemView);

    }

    private void initviews(View itemView) {
        imageView = itemView.findViewById(R.id.imageview);
        tvTittle = itemView.findViewById(R.id.TvTittle1);
        tvSubTittl = itemView.findViewById(R.id.TvTittle2);
    }

    public void setData(ResponseModel responseModel){
        tvTittle.setText(responseModel.getTitle());
        tvSubTittl.setText(responseModel.getSubTitle());
        Glide.with(imageView).load(responseModel.getImage()).into(imageView);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                BlankFragment blankFragment = new BlankFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.flcontanier,blankFragment,"blankFragment").addToBackStack(null).commit();
            }
        });


    }


}
