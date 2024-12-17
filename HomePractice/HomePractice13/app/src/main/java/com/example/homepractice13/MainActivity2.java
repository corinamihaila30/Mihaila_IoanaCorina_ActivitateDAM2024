package com.example.homepractice13;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity2 extends AppCompatActivity {
    ArrayList<String> linkuri=new ArrayList<>();
    ArrayList<Bitmap> listaImg = new ArrayList<>();
    ArrayList<String> titluri=new ArrayList<>();
    ArrayList<Imagine> listaImagini = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        linkuri.add("https://upload.wikimedia.org/wikipedia/commons/b/b4/Harvard_University_Pic.jpg");
        linkuri.add("https://media.wired.com/photos/65e9c14ff4ce71123a9b1b8f/4:3/w_3692,h_2769,c_limit/Cambridge.jpg");
        linkuri.add("https://ichef.bbci.co.uk/news/1024/branded_news/2c03/live/64d39070-8596-11ef-addc-5556603eb4c1.jpg");
        titluri.add("Harvard");
        titluri.add("Cambridge");
        titluri.add("Oxford");
        Executor executor= Executors.newSingleThreadExecutor();
        Handler handler=new Handler(Looper.getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection=null;
                for(String s: linkuri){
                    try {
                        URL url=new URL(s);
                        connection = (HttpURLConnection) url.openConnection();
                        InputStream is=connection.getInputStream();
                        Bitmap img = BitmapFactory.decodeStream(is);
                        listaImg.add(img);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }handler.post(new Runnable() {
                    @Override
                    public void run() {
                        for(int i =0;i<linkuri.size();i++){
                            Imagine img=new Imagine(titluri.get(i),listaImg.get(i),linkuri.get(i));
                            listaImagini.add(img);
                        }
                        ImagineAdapter adapter =new ImagineAdapter(getApplicationContext(),listaImagini,R.layout.idtemplate);
                        ListView lw =findViewById(R.id.listview);
                        lw.setAdapter(adapter);

                        SharedPreferences sharedPreferences = getSharedPreferences("obiecte",MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        for(int i=0;i<listaImagini.size();i++){
                            editor.putString(listaImagini.get(i).getName() + listaImagini.get(i).getLink(),listaImagini.get(i).toString());
                            editor.commit();
                        }
                    }
                });

            }
        });

    }
}