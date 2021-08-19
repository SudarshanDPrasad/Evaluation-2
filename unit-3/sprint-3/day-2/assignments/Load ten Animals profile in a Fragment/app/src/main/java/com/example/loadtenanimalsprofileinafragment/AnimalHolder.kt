package com.example.loadtenanimalsprofileinafragment

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*

class AnimalHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun setdata(animalModel: AnimalModel) {

        view.apply {
            TvName.text = animalModel.name
            Glide.with(IvAnimal).load(animalModel.image).into(IvAnimal)
        }
    }
}