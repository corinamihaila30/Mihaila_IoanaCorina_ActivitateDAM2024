package com.example.homepractice6;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    ArrayList<Pizza> listaPizza=new ArrayList<>();

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
        String link = "https://dummyjson.com/recipes?limit=10";
        Executor executor= Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection=null;
                try {
                    URL url=new URL(link);
                    connection= (HttpURLConnection) url.openConnection();
                    InputStream is=connection.getInputStream();
                    InputStreamReader isr=new InputStreamReader(is);
                    BufferedReader br=new BufferedReader(isr);
                    String s = br.readLine();
                    StringBuffer sb=new StringBuffer();
                    while (s!=null){
                        sb.append(s);
                        s = br.readLine();
                    }
                    JSONObject obj=new JSONObject(sb.toString());
                    JSONArray recipes = obj.getJSONArray("recipes");
                    for(int i = 0;i<recipes.length();i++){
                        JSONObject ob = recipes.getJSONObject(i);
                        String name = ob.getString("name");
                        String ingredinte =  String.valueOf(ob.getJSONArray("ingredients"));
                        String instructiuni = String.valueOf(ob.getJSONArray("instructions"));
                        Pizza p=new Pizza(name,instructiuni,ingredinte);
                        listaPizza.add(p);
                    }


                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ListView lw = findViewById(R.id.listview);
                        ArrayAdapter<Pizza> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,listaPizza);
                        lw.setAdapter(adapter);

                    }
                });

            }
        });

    }
}