package com.example.homepractice1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void deschide(View view){
        Intent intent=new Intent(getApplicationContext(), ProfileActivityForm.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        Log.w("MainActivity","OnStart s-a apelat");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.w("MainActivity","OnResume s-a apelat");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.w("MainActivity","OnPause s-a apelat");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Log.w("MainActivity","OnRestart s-a apelat");
        super.onRestart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w("MainActivity","OnStop s-a apelat");
    }

    @Override
    protected void onDestroy() {
        Log.w("MainActivity","OnDestroy s-a apelat");
        super.onDestroy();
    }
}