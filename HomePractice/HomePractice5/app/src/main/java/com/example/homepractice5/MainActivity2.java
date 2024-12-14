package com.example.homepractice5;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.EditText;
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
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity2 extends AppCompatActivity {

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
        Vreme v = getIntent().getParcelableExtra("vreme");
        Log.i("main2",v.toString());
        String apiKey = "015f2c7aec29c9c1152257c25f204a9d";
        String link = "https://api.openweathermap.org/data/2.5/weather?lat=" +
                v.getLatitudine().toString() +"&lon=" + v.getLatitudine().toString() + "&appid=" + apiKey;
        Executor executor= Executors.newSingleThreadExecutor();
        Handler handler=new Handler(Looper.getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection=null;
                MainWeather w;
                try {
                    URL url = new URL(link);
                    connection= (HttpURLConnection) url.openConnection();
                    InputStream is=connection.getInputStream();
                    InputStreamReader isr=new InputStreamReader(is);
                    BufferedReader br=new BufferedReader(isr);
                    String s = br.readLine();
                    StringBuffer buffer=new StringBuffer();

                    while(s!=null){
                        buffer.append(s);
                        s = br.readLine();
                    }
                    JSONObject obj=new JSONObject(buffer.toString());
                    JSONObject main = obj.getJSONObject("main");
                    Double temp = main.getDouble("temp");
                    Double feels = main.getDouble("feels_like");
                    Double temo_min = main.getDouble("temp_min");
                    Double temp_max = main.getDouble("temp_max");
                    Integer pressure = main.getInt("pressure");
                    Integer humidity = main.getInt("humidity");
                    Integer sea = main.getInt("sea_level");
                    Integer grd = main.getInt("grnd_level");
                    w=new MainWeather(temp,feels,temo_min,temp_max,pressure,humidity,sea,grd);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        TextView afisare = findViewById(R.id.main2_text);
                        afisare.setText(w.toString());
                    }
                });
            }
        });

    }
}