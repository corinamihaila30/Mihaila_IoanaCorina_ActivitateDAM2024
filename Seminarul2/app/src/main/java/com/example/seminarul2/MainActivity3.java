package com.example.seminarul2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    private String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    @Override
    protected void onStart() {
        Intent it = getIntent();
         msg = it.getStringExtra("Mesaj");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("onResume",msg);
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
//        TextView textView = findViewById(R.id.deGasit);
//        textView.setText(msg);
        super.onResume();
    }
}