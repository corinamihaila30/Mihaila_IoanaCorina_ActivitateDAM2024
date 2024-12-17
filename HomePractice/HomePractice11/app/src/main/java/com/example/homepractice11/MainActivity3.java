package com.example.homepractice11;

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
    ArrayList<Student> listaStudenti=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
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
                FacultateDatabase database= Room.databaseBuilder(getApplicationContext(),FacultateDatabase.class,"obiecte").build();
                StudentDA0 studentDA0 = database.returnDAO();
                listaStudenti = (ArrayList<Student>) studentDA0.selectAll();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ArrayAdapter<Student> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,listaStudenti);
                        ListView lw=findViewById(R.id.listview1);
                        lw.setAdapter(adapter);
                    }
                });

            }
        });

    }
}