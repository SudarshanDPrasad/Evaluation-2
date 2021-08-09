package com.example.evaluation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView SplashScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SplashScreen = findViewById(R.id.SplashScreen);

        SplashScreen.animate().translationX(3000).translationY(3000).setStartDelay(3000);
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent intent = new Intent(MainActivity.this,ItemListActivity.class);
               startActivity(intent);
               finish();
           }
       },3000);

    }
}