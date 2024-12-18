package com.example.testprep02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    ArrayAdapter<AirlineTicket> listaAdapter;
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
        ArrayList<AirlineTicket> tickets = intent.getParcelableArrayListExtra("lista");
        //ArrayAdapter adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,tickets);
        AdapterPersonalizat adapter=new AdapterPersonalizat(getApplicationContext(),tickets, R.layout.lytemplate);
        ListView lw=findViewById(R.id.lwAct3);
        lw.setAdapter(adapter);
        //lw.setAdapter(adapter);
        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),tickets.get(i).toString(),Toast.LENGTH_LONG).show();

            }
        });

        lw.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                tickets.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

}