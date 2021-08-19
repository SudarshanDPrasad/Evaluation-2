package com.example.loadtenanimalsprofileinafragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AnimalAdaptor(val animalModel: List<AnimalModel>) : RecyclerView.Adapter<AnimalHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return AnimalHolder(View)
    }

    override fun onBindViewHolder(holder: AnimalHolder, position: Int) {
        val model = animalModel[position]
        holder.setdata(model)
    }

    override fun getItemCount(): Int {
        return animalModel.size
    }
}