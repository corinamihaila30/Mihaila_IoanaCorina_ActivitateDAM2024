package com.example.testprep01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.testprep01.Clase.AdapterCafea;
import com.example.testprep01.Clase.Cafea;

import java.util.ArrayList;

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

        Intent it= getIntent();
        ArrayList<Cafea> array = it.getParcelableArrayListExtra("cafele");
        //Toast.makeText(getApplicationContext(),array.toString(),Toast.LENGTH_LONG).show();
        Log.w("MainAct2",array.toString());
        //ArrayAdapter<Cafea> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,array);

        AdapterCafea adapter=new AdapterCafea(array,getApplicationContext(), R.layout.templatecafea);
        ListView lw = findViewById(R.id.lwAct2);
        lw.setAdapter(adapter);

    }
}