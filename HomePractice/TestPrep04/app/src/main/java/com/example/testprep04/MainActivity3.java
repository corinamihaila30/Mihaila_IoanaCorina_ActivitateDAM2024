package com.example.testprep04;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    ArrayList<Carte> listaC=null;
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
        Intent intent=getIntent();
        listaC = intent.getParcelableArrayListExtra("lista");
        //ArrayAdapter<Carte> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,listaC);
        AdapterPersonalizat adapter=new AdapterPersonalizat(getApplicationContext(),R.layout.lytemplate,listaC);
        ListView lw =  findViewById(R.id.Act3Ly);
        lw.setAdapter(adapter);

    }
}