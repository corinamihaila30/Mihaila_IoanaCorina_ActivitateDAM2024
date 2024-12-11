package com.example.seminar4.myclasses;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.seminar4.R;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity3 extends AppCompatActivity {
    ArrayList<String> stringCamere = new ArrayList<>();

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

        SharedPreferences sp = getSharedPreferences("obiecteCamere",MODE_PRIVATE);
        Map<String,?> hashObj = sp.getAll();
        for(Map.Entry<String,?> i: hashObj.entrySet() ){
            stringCamere.add(i.getValue().toString());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,stringCamere);
        ListView lw = findViewById(R.id.list_view_3);
        lw.setAdapter(adapter);
    }
}