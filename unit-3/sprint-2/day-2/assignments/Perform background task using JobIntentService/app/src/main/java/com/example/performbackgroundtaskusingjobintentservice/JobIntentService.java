package com.example.performbackgroundtaskusingjobintentservice;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;


public class JobIntentService extends androidx.core.app.JobIntentService {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    public static final String TAG = JobIntentService.class.getSimpleName();

    @Override
    protected void onHandleWork(@NonNull Intent intent) {

        Log.d(TAG, "onHandler");

        if (intent.getStringExtra("Job").equals("1")) {
            for (int i = 0; i <= 10; i++) {
                Log.d(TAG, "Task 1 " + Thread.currentThread().getName() + "-" + i);
            }

        } else if (intent.getStringExtra("Job").equals("2")) {
            for (int i = 0; i <= 12; i++) {
                Log.d(TAG, "Task 2 " + Thread.currentThread().getName() + "-" + i);
            }
        }
    }

    static void ework(Context context,Intent intent){
        enqueueWork(context,JobIntentService.class,1807,intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}