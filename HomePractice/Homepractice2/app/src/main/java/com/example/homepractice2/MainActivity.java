package com.example.homepractice2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ArrayAdapter;
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

public class MainActivity extends AppCompatActivity {
    ArrayList<String> links=new ArrayList<>();
    ArrayList<Imagine> listaImagini=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //links.add("https://www.shutterstock.com/image-photo/manhattan-new-york-city-usa-260nw-2170041575.jpg");
        links.add("https://static.leonardo-hotels.com/image/executive-room-with-king-bed_35ba711c8e3052877659372a86e4bb3a_1200x800_mobile_3.jpeg");
        links.add("https://media.architecturaldigest.com/photos/5783da093cba0f2e2ca06bab/master/w_1600%2Cc_limit/Shangri-La%25202.jpg");
        ArrayList<String> texts=new ArrayList<>();
        texts.add("Barcelona");
        texts.add("Paris");

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler=new Handler(Looper.getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection=null;

                for(int i = 0; i < links.size();i++ ){
                    try {
                        URL url = new URL(links.get(i));
                        connection= (HttpURLConnection) url.openConnection();
                        InputStream is=connection.getInputStream();
                        Bitmap image = BitmapFactory.decodeStream(is);
                        Imagine img = new Imagine(texts.get(i), image, links.get(i));
                        listaImagini.add(img);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            ListView lv=findViewById(R.id.imagini_listview);
                            ImagineAdapter adapter=new ImagineAdapter(getApplicationContext(),listaImagini, R.layout.template);
                            //ArrayAdapter adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);
                            lv.setAdapter(adapter);
                        }
                    });
                }
            }
        });


    }


}