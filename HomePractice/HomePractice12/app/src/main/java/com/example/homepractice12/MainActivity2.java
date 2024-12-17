package com.example.homepractice12;

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

public class MainActivity2 extends AppCompatActivity {
    ArrayList<Produs> listaProduse=new ArrayList<>();

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
        Executor executor=Executors.newSingleThreadExecutor();
        Handler handler=new Handler(Looper.getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                MagazinDatabase magazinDatabase= Room.databaseBuilder(getApplicationContext(), MagazinDatabase.class,"obiecte").build();
                ProdusDAO produsDAO = magazinDatabase.returnDao();
                listaProduse = (ArrayList<Produs>) produsDAO.selectAll();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ArrayAdapter<Produs> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,listaProduse);
                        ListView lw = findViewById(R.id.listview1);
                        lw.setAdapter(adapter);
                    }
                });
            }
        });
    }
}