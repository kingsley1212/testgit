package com.aaa.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main3Activity extends AppCompatActivity {
    private ImageView imagev;
    private TextView textv;
    String url1 = "441781199602186974";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        imagev = (ImageView) findViewById(R.id.imagev);
        textv = (TextView) findViewById(R.id.textv);
String s = url1.substring(0,4)+"******"+url1.substring(url1.length()-4,url1.length());
textv.setText(s);

    }

    private void getBitmap() {
        Thread NetThread = new Thread(){
            @Override
            public void run() {
                try {
                    URL url = new URL(url1);
                    try {
                        URLConnection connection = url.openConnection();
                        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
                        int length = httpURLConnection.getContentLength();
                        connection.connect();
                            InputStream inputStream = connection.getInputStream();
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream,length);
                            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            bufferedInputStream.close();
                            inputStream.close();
                            saveBitmap(bitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        };
        NetThread.start();

    }

    private void saveBitmap(Bitmap bitmap) {
        File aapdir = new File(Environment.getExternalStorageDirectory(), "林师金相册");
        if (!aapdir.exists()) {
            aapdir.mkdir();
        }
        String[] strings = url1.split("/");
        String fileName = strings[strings.length - 1];
        final File file = new File(aapdir, fileName);
        try {
            FileOutputStream fileOutputStream= new FileOutputStream(file);
          bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
            try {
                fileOutputStream.flush();
                fileOutputStream.close();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                     sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(file)));
                        Toast.makeText(Main3Activity.this, "sdadfdsfa", Toast.LENGTH_SHORT).show();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
