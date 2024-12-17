package com.example.homepractice9;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity3 extends AppCompatActivity {
    ArrayList<Haina> listaH=new ArrayList<>();

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
        listaH = getIntent().getParcelableArrayListExtra("lista");
        ArrayAdapter<Haina> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,listaH);
        ListView lw = findViewById(R.id.listview);
        lw.setAdapter(adapter);
        lw.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Executor executor=Executors.newSingleThreadExecutor();
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        SharedPreferences sp= getSharedPreferences("obiecte",MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString(listaH.get(i).getDenumire() + listaH.get(i).getPret(),listaH.get(i).toString());
                        editor.commit();
                    }
                });

                return false;
            }
        });
    }
}