package com.example.datatracker;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.http.Url;

public class DataViewHolder extends RecyclerView.ViewHolder {

    private TextView mtvDate;
    private TextView mtvPositve;
    private TextView mtvNegative;
    private TextView mtvhospitalizedCurrently;
    private TextView mtvonVentilatorCurrently;
    private TextView mtvdeath;
    private TextView tvdateChecked;
    private CardView mcardview;


    public DataViewHolder(@NonNull View itemView) {
        super(itemView);
        initviews(itemView);
    }

    private void initviews(View itemView) {
        mtvDate = itemView.findViewById(R.id.tvDate);
        mtvPositve = itemView.findViewById(R.id.tvPositve);
        mtvNegative = itemView.findViewById(R.id.tvNegative);
        mtvhospitalizedCurrently = itemView.findViewById(R.id.tvhospitalizedCurrently);
        mtvonVentilatorCurrently = itemView.findViewById(R.id.tvonVentilatorCurrently);
        mtvdeath = itemView.findViewById(R.id.tvdeath);
        tvdateChecked = itemView.findViewById(R.id.tvdateChecked);
        mcardview = itemView.findViewById(R.id.cardview);
    }

    public void setData(ResponseModel responseModel, OnLongClick onLongClick) {

        mtvDate.setText(responseModel.getDate() + "");
        mtvPositve.setText(responseModel.getPositive() + "");
        mtvNegative.setText(responseModel.getNegative() + "");
        mtvhospitalizedCurrently.setText(responseModel.getHospitalizedCurrently() + "");
        mtvonVentilatorCurrently.setText(responseModel.getOnVentilatorCurrently() + "");
        mtvdeath.setText(responseModel.getDeath() + "");
        tvdateChecked.setText(responseModel.getDateChecked() + "");

        mcardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLongClick.OnClick(responseModel);
            }
        });

        mcardview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onLongClick.remove(responseModel);
                return false;
            }

        });
    }
}
