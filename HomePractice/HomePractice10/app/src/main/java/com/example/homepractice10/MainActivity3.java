package com.example.homepractice10;

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

public class MainActivity3 extends AppCompatActivity {
    ArrayList<Curs> listaCursuri=new ArrayList<>();

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
        listaCursuri = getIntent().getParcelableArrayListExtra("lista");
        ArrayAdapter<Curs> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,listaCursuri);
        ListView lw=findViewById(R.id.listview1);
        lw.setAdapter(adapter);
        lw.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                SharedPreferences sp=getSharedPreferences("obiecte",MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString(listaCursuri.get(i).getDenumire()+listaCursuri.get(i).getPret(),listaCursuri.get(i).toString());
                editor.commit();
                return false;
            }
        });

    }
}