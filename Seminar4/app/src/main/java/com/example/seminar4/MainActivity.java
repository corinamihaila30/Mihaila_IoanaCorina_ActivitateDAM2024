package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Database;

import com.example.seminar4.myclasses.Camera;
import com.example.seminar4.myclasses.CameraDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    CameraDatabase database=null;
    private List<Camera> listac=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listac=new ArrayList<>();

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //button
        Button btn =findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(getApplicationContext(), MainActivity2.class);
                startActivityForResult(it,403);
            }
        });

        Button listaBtn= findViewById(R.id.button3);
        listaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(getApplicationContext(), ListaCamereRezervate.class);
                it.putParcelableArrayListExtra("camere",(ArrayList<? extends Parcelable>) listac);
                startActivity(it);
            }
        });

        Button btn3=findViewById(R.id.mainBtn4);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), AfisareImagini.class);
                startActivity(intent);
            }
        });

//        Executor executor= Executors.newSingleThreadExecutor();
//        Handler handler=new Handler(Looper.myLooper());
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                database.getDatabase();
//
//            }
//        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==403){
            if(resultCode==RESULT_OK){
                Camera camera=data.getParcelableExtra("rezervare");
                listac.add(camera);

            }
        }
    }


}