package com.example.loadtenanimalsprofileinafragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_animal.*


class AnimalFragment : Fragment() {

    private val animalList: ArrayList<AnimalModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buildList()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        val animalAdaptor = AnimalAdaptor(animalList)
        val linearLayoutManager = LinearLayoutManager(activity)
        recyclerView.adapter =  animalAdaptor
        recyclerView.layoutManager = linearLayoutManager


    }

    private fun buildList() {
        var List = 10
        while (List --> 0){
            val animal1 = AnimalModel("Dog","https://www.pixelstalk.net/wp-content/uploads/2016/04/Golden-retriever-dogs-high-definition-wallpapers.jpg")
            animalList.add(animal1)
            val animal2 = AnimalModel("German Shepeard","https://www.rover.com/blog/wp-content/uploads/2020/06/German-Shepherd-1-1024x683.jpg")
            animalList.add(animal2)
            val animal3 = AnimalModel("Husky","https://hddesktopwallpapers.in/wp-content/uploads/2015/09/husky-images.jpg")
            animalList.add(animal3)

        }

}
}