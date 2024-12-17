package com.example.homepractice8;

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
    ArrayList<Vacanta> listaV=new ArrayList<>();
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

        Executor executor= Executors.newSingleThreadExecutor();
        Handler handler=new Handler(Looper.getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                AgendaDatabase agendaDatabase= Room.databaseBuilder(getApplicationContext(), AgendaDatabase.class,"agenda").build();
                VacantaDAO vacantaDAO = agendaDatabase.returnDAO();
                listaV = (ArrayList<Vacanta>) vacantaDAO.selectAll();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ArrayAdapter<Vacanta> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,listaV);
                        ListView lw = findViewById(R.id.listview);
                        lw.setAdapter(adapter);
                    }
                });
            }

        });
    }
}