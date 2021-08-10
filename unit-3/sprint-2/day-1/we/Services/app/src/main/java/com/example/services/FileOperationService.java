package com.example.services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Objects;

public class FileOperationService extends Service {

    private static final String TAG = FileOperationService.class.getSimpleName(); // Global variable to TAG

    private String name = "";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    public FileOperationService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        /* this run in a MainThread*/
        Log.d(TAG, "onStartCommand");
        Log.d(TAG, Thread.currentThread().getName()); // To check in which thread its running
        showNotificationAndStartForeGround();
        if (intent != null) {
            name = intent.getStringExtra("name");
        }
        launchBackGroundThread();
        return super.onStartCommand(intent, flags, startId);
    }

    private void launchBackGroundThread() {
        Thread thread = new Thread(task);
        thread.start();
    }

    private Runnable task = new Runnable() {
        @Override
        public void run() {
            saveToFile();
        }
    };

    /**
     * Saving the deatils to the File
     * this below one runs in background thread
     */
    private void saveToFile() {
        /* Create a Directory*/

        try {
            File directory = new File(getFilesDir() + File.separator + "NameFolder");

            if (!directory.exists()) {
                directory.mkdir();
            }

            /* Create a File inside the directory */

            File file = new File(directory, "name.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream);
            writer.append(name + "\n"); // adding to the file we should use "append"
            writer.close();

            Intent intent = new Intent("com.xyz.service");
            intent.putExtra("data","write done");
            sendBroadcast(intent);
        } catch (Exception e) {

        }
    }
    private void showNotificationAndStartForeGround() {
        createChannel();

        NotificationCompat.Builder notificationBuilder = null;
        notificationBuilder = new NotificationCompat.Builder(this, "CHANNEL_ID")
                .setContentTitle("Notification Service is running ")
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        Notification notification = null;
        notification = notificationBuilder.build();
        startForeground(120, notification);
    }



    /*
Create noticiation channel if OS version is greater than or eqaul to Oreo
*/
    public void createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("CHANNEL_ID", "CHANNEL_NAME", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Call Notifications");
            Objects.requireNonNull(this.getSystemService(NotificationManager.class)).createNotificationChannel(channel);
        }
    }

}


/*
name.txt

sudarshan d prasad sidi


To print the name in the next Line write \n in writer check line 89

 */