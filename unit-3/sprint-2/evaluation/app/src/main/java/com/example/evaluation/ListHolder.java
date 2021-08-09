package com.example.evaluation;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ListHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView tvTittle, tvSubTittl;


    public ListHolder(@NonNull View itemView) {
        super(itemView);
        initviews(itemView);

    }

    private void initviews(View itemView) {
        imageView = itemView.findViewById(R.id.imageview);
        tvTittle = itemView.findViewById(R.id.TvTittle1);
        tvSubTittl = itemView.findViewById(R.id.TvTittle2);
    }

    public void setData(ResponseModel responseModel) {
        tvTittle.setText(responseModel.getTitle());
        tvSubTittl.setText(responseModel.getSubTitle());
        Glide.with(imageView).load(responseModel.getImage()).into(imageView);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                BlankFragment blankFragment = new BlankFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.flcontanier, blankFragment, "blankFragment").addToBackStack(null).commit();
            }
        });


    }


    public class ListAdaptor extends RecyclerView.Adapter<ListHolder> {

        private List<ResponseModel> responseModelList;
        private ItemClickListener clickListener;


        public ListAdaptor(List<ResponseModel> responseModelList) {
            this.responseModelList = responseModelList;
            this.clickListener = clickListener;

        }

        @NonNull
        @Override
        public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
            return new ListHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ListHolder holder, int position) {
            ResponseModel responseModel = responseModelList.get(position);
            holder.setData(responseModel);
            holder.tvTittle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onItemClick(responseModelList.get(position));
                }
            });

        }

        @Override
        public int getItemCount() {
            return responseModelList.size();
        }
    }

}