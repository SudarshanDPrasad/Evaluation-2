package com.example.services;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private EditText ettoenter;
    private Button btntosend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
        IntentFilter intentFilter = new IntentFilter("com.xyx.service");
        registerReceiver(serviceReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(serviceReceiver);
    }

    private void initviews() {
        ettoenter = findViewById(R.id.ettoenter);
        btntosend = findViewById(R.id.btntosend);
        btntosend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FileOperationService.class);
                intent.putExtra("name", ettoenter.getText().toString());
                startService(intent);
            }
        });
    }

    private BroadcastReceiver serviceReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Toast.makeText(context,intent.getStringExtra("data"),Toast.LENGTH_SHORT).show();
        }
    };

}