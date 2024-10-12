package com.example.seminarul2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void deschide(View view){
        Intent it = new Intent(getApplicationContext(),MainActivity3.class);
        it.putExtra("Mesaj","Salut activitatea 3!");
        startActivity(it);

    }
}