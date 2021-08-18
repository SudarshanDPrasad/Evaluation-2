package com.example.apicallingusingservice;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MyIntentService extends IntentService {

    private final String TAG = MyIntentService.class.getSimpleName();


    public MyIntentService(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            showNotificationAndStartForeGround();
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private void showNotificationAndStartForeGround() {
        String NOTIFICATION_CHANNEL_ID = "Aditya";
        String channelName = "Background Service";
        NotificationChannel chan = new NotificationChannel(NOTIFICATION_CHANNEL_ID, channelName, NotificationManager.IMPORTANCE_NONE);
        chan.setLightColor(Color.BLUE);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        assert manager != null;
        manager.createNotificationChannel(chan);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
        Notification notification = notificationBuilder.setOngoing(true)
                .setContentTitle("App is running in background")
                .setContentText("Fetching the data")
                .setPriority(NotificationManager.IMPORTANCE_MIN)
                .setCategory(Notification.CATEGORY_SERVICE)
                .build();
        startForeground(2, notification);
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent");
        URL url = null;
        try {
            url = new URL("https://jsonplaceholder.typicode.com/posts/1");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            assert intent != null;

            int data = inputStreamReader.read();
            StringBuffer stringBuffer = new StringBuffer();

            while (data != -1) {
                char ch = (char) data;
                stringBuffer.append(ch);
                data = inputStreamReader.read();
            }
            buildResponseData(stringBuffer);

        } catch (Exception e) {
            Log.d("tag", e.getMessage());
        }
    }

    private void buildResponseData(StringBuffer stringBuffer) {
        String json = stringBuffer.toString();
        try {
            JSONObject jsonObject = new JSONObject(json);
            int id = jsonObject.getInt("id");
            String title = jsonObject.getString("title");
            String body = jsonObject.getString("title");
            String userId = jsonObject.getString("body");

            //sending broadcast
            Intent intent = new Intent("com.aditya.localBroadCast");
            intent.putExtra("title", title);
            sendBroadcast(intent);


        } catch (Exception e) {
            Toast.makeText(MyIntentService.this, "error is in buildResponseData : " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}