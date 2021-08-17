package com.example.performbackgroundtaskusingjobintentservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Button btntask1, btntask2;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
    }

    private void initviews() {
        btntask1 = findViewById(R.id.task1);
        btntask2 = findViewById(R.id.task2);
        intent = new Intent(MainActivity.this, JobIntentService.class);

        btntask1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("Job", "1");
                JobIntentService.ework(MainActivity.this, intent);


            }
        });

        btntask2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("Job", "2");
                JobIntentService.ework(MainActivity.this, intent);
            }
        });
    }
}