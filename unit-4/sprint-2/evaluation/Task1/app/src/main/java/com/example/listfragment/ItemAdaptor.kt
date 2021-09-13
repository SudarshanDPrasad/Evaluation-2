package com.example.listfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdaptor(val addModel: List<AddModel>) : RecyclerView.Adapter<ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        var addModel: AddModel = addModel[position]
        holder.tvsarchName.text = addModel.addItemName
        holder.tvSearchPrice.text = addModel.addPrice.toString()

    }

    override fun getItemCount(): Int {

        return addModel.size
    }
}

class ItemHolder( view: View) : RecyclerView.ViewHolder(view) {

    var tvsarchName: TextView
    var tvSearchPrice: TextView

    init {
        tvsarchName = view.findViewById(R.id.tvsarchName)
        tvSearchPrice = view.findViewById(R.id.tvSearchPrice)

    }

}