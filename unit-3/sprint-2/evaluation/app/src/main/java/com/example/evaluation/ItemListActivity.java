package com.example.evaluation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.FrameLayout;

public class ItemListActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list2);
        fragmentManager = getSupportFragmentManager();
        replace();
        initviews();
    }

    private void initviews() {
        frameLayout = findViewById(R.id.framelayout);
    }

    private void replace(){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ItemListFragment itemListFragment = new ItemListFragment();
        fragmentTransaction.replace(R.id.framelayout,itemListFragment,"itemListFragment").commit();
    }
}