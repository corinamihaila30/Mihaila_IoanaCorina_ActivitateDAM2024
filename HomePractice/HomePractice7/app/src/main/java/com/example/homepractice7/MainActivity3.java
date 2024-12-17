package com.example.homepractice7;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity3 extends AppCompatActivity {
    ArrayList<Prajitura> listaP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Executor executor=Executors.newSingleThreadExecutor();
        Handler handler=new Handler(Looper.getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                CofetarieDatabase cofetarieDatabase = Room.databaseBuilder(getApplicationContext(), CofetarieDatabase.class,"cofetarie").build();
                PrajituraDAO prajituraDAO = cofetarieDatabase.returnDAO();
                listaP = (ArrayList<Prajitura>) prajituraDAO.selectPrajituri();
            }
        });

        handler.post(new Runnable() {
            @Override
            public void run() {
                ArrayAdapter<Prajitura> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,listaP);
                ListView listView=findViewById(R.id.listview);
                listView.setAdapter(adapter);
            }
        });

    }
}