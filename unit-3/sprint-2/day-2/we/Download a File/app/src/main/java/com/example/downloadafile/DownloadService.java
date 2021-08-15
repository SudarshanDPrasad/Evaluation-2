package com.example.downloadafile;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;


public class DownloadService extends IntentService {

    private static final String TAG = DownloadService.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    public DownloadService() {
        super("Random");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        downloadFile();
    }

    public void downloadFile() {
        try {

            File directory = new File(getFilesDir() + File.separator + "Vogella");

            if (!directory.exists()) {
                directory.mkdir();
            }

            File file = new File(directory, "vogella.html");

            if (!file.exists()) {
                file.createNewFile();
            }

            URL url = new URL("https://www.vogella.com/index.html");

            InputStream inputStream = url.openConnection().getInputStream();

            InputStreamReader reader = new InputStreamReader(inputStream); // pointing to the 1st character
            FileOutputStream writer = new FileOutputStream(file, true); // to write the download file

            int data = reader.read();
            while (data != -1) {
                char ch = (char) data;
                writer.write(ch);
                data = reader.read(); // pointer will move to the next character
            }

            // Read from file
            FileInputStream fileInputStream = new FileInputStream(file);
            int fileData = fileInputStream.read();
            StringBuffer stringBuffer = new StringBuffer();
            while (fileData != -1) {
                char ch = (char) fileData;
                stringBuffer = stringBuffer.append(ch);
                fileData = fileInputStream.read();
            }

            Log.d(TAG,stringBuffer.toString());

        } catch (Exception e) {

        }
    }
}