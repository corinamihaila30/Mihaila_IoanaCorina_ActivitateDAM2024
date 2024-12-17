package com.example.homepractice12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    ArrayList<Produs> listaProduse=new ArrayList<>();

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
        Executor executor= Executors.newSingleThreadExecutor();
        String link="https://dummyjson.com/products?limit=10";
        executor.execute(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection=null;
                try {
                    URL url=new URL(link);
                    MagazinDatabase magazinDatabase= Room.databaseBuilder(getApplicationContext(),MagazinDatabase.class,"obiecte").build();
                    ProdusDAO produsDAO = magazinDatabase.returnDao();
                    produsDAO.deleteAll();
                    connection = (HttpURLConnection) url.openConnection();
                    InputStream is = connection.getInputStream();
                    InputStreamReader isr=new InputStreamReader(is);
                    BufferedReader br=new BufferedReader(isr);
                    String s = br.readLine();
                    StringBuffer sb = new StringBuffer();
                    while(s!=null){
                        sb.append(s);
                        s = br.readLine();
                    }
                    JSONObject obj = new JSONObject(sb.toString());
                    JSONArray array = obj.getJSONArray("products");
                    System.out.println("lalala");
                    for(int i=0;i<array.length();i++){
                        JSONObject o = array.getJSONObject(i);
                        Integer id = o.getInt("id");
                        String name = o.getString("title");
                        Float pret = (float) o.getDouble("price");
                        Produs p=new Produs(id,name,pret);
                        listaProduse.add(p);
                        produsDAO.insertProdus(p);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Button btn=findViewById(R.id.main1_btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });



    }
}