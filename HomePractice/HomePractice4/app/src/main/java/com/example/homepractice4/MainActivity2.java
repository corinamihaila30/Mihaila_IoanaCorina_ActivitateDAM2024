package com.example.homepractice4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity2 extends AppCompatActivity {

    ArrayList<String> listaLinkuri=new ArrayList<>();
    ArrayList<Bitmap> listaImag=new ArrayList<>();
    ArrayList<String> listaNume=new ArrayList<>();
    ArrayList<Caine> listaCaini=new ArrayList<>();

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

        listaLinkuri.add("https://www.vanzaricaini.ro/uploads/16d51076ab13b940f92bdb5ddbcd8779.jpg");
        listaLinkuri.add("https://www.purina.ro/sites/default/files/2023-03/Untitled.png");
        listaLinkuri.add("https://i.pinimg.com/736x/ba/fa/91/bafa91f8875a2bc6657236b9b36d9372.jpg");
        listaLinkuri.add("https://www.dogster.com/wp-content/uploads/2023/09/siberian-husky-dog-standing-on-grass_Edalin-Photography_Shutterstock.jpg");
        listaNume.add("Otto");
        listaNume.add("Cindy");
        listaNume.add("Goovy");
        listaNume.add("Lolita");

        Executor executor= Executors.newSingleThreadExecutor();
        Handler handler=new Handler(Looper.getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection=null;
                try {
                    for(String s: listaLinkuri){
                        URL url=new URL(s);
                        connection= (HttpURLConnection) url.openConnection();
                        InputStream is = connection.getInputStream();
                        Bitmap bm= BitmapFactory.decodeStream(is);
                        listaImag.add(bm);
                    }
                    for(int i=0;i<listaLinkuri.size();i++){
                        String nume=listaNume.get(i);
                        Bitmap imagine = listaImag.get(i);
                        String link=listaLinkuri.get(i);
                        Caine c=new Caine(nume,imagine,link);
                        listaCaini.add(c);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        AdapterImagini adapter=new AdapterImagini(getApplicationContext(),listaCaini,R.layout.lytemplate);
                        ListView lw = findViewById(R.id.listview_imag);
                        lw.setAdapter(adapter);
                        //adapter.notifyDataSetChanged();
                    }
                });
            }
        });


    }
}