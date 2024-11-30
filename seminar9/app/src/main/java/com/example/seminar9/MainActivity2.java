package com.example.seminar9;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class MainActivity2 extends AppCompatActivity {
    ArrayList<Situatie> arraySituatii=new ArrayList<>();
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

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.myLooper());
        String link = "https://pdm.ase.ro/situatii.json";
        executor.execute(new Runnable() {
            @Override
            public void run() {
                    HttpURLConnection connection=null;
                    try {
                        URL url=new URL(link);
                        connection= (HttpURLConnection) url.openConnection();
                        InputStream is = connection.getInputStream();
                        InputStreamReader isr = new InputStreamReader(is);
                        BufferedReader br = new BufferedReader(isr);
                        String line = br.readLine();
                        StringBuffer sb = new StringBuffer();
                        sb.append(line);
                        while(line != null){
                            sb.append(line);
                            line = br.readLine();
                        }
                        System.out.println(sb);
                        JSONObject obiect = new JSONObject(sb.toString());
                        JSONArray vector = obiect.getJSONArray("Situatii");
                        for(int i=0;i<vector.length();i++){
                            String disciplina = obiect.getString("disciplina");
                            String activitate = obiect.getString("activitate");
                            Float valoare = Float.valueOf(obiect.getString("valoare"));
                            Float pondere = Float.valueOf(obiect.getString("pondere"));
                            String data = obiect.getString("data");
                            String descriere = obiect.getString("descriere");
                            Situatie s = new Situatie(disciplina,activitate,valoare,pondere,data,descriere);
                            System.out.println(s);
                        }


                    } catch (IOException | JSONException e) {
                        throw new RuntimeException(e);
                    }
            }
        });


    }
}