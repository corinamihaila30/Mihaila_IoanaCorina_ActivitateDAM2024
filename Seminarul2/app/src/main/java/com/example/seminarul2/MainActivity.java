package com.example.seminarul2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // on Create initializeaza activitatea
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("OnCreate","Eroare in onCreate");
        Log.w("OnCreate","Warning in onCreate");
        Log.v("OnCreate","V. in onCreate");
        Log.i("OnCreate","I in onCreate");
        Log.d("OnCreate","Debugging in onCreate");
    }

    @Override
    protected void onStart() {
        //act este vizibila dar nu este interactiva
        Log.e("onStart","Eroare in OnStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        //act devine interactiva pt utilizator
        Log.e("onResume","Eroare in onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        //activitatea este in pauza sau in panoul de apllicatii
        Log.e("onPause","Eroare in onPause");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        //se apeleaza din nou start
        Log.e("onRestart","Eroare in onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        //act este distrusa, dispare de tot
        Log.e("onDestroy","Eroare in onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        //este in proces de distrugere
        Log.e("onStop","Eroare in onStop");
        super.onStop();
    }
}