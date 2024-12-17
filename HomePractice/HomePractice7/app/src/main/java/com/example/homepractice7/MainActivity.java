package com.example.homepractice7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    ArrayList<Prajitura> listaP;


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

        Executor executor= Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                CofetarieDatabase cofetarieDatabase = Room.databaseBuilder(getApplicationContext(), CofetarieDatabase.class,"cofetarie").build();
                PrajituraDAO prajituraDAO = cofetarieDatabase.returnDAO();
                listaP = (ArrayList<Prajitura>) prajituraDAO.selectPrajituri();
            }
        });
        Button btn= findViewById(R.id.main1_btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity2.class);
                startActivityForResult(intent,109);
            }
        });

        Button btn2=findViewById(R.id.main1_btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity3.class);
                //intent.putParcelableArrayListExtra("lista",listaP);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==109){
            if(resultCode==RESULT_OK){
                Prajitura p =data.getParcelableExtra("prajitura");
                listaP.add(p);
                Executor executor=Executors.newSingleThreadExecutor();
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        CofetarieDatabase cofetarieDatabase=Room.databaseBuilder(getApplicationContext(), CofetarieDatabase.class,"cofetarie").build();
                        PrajituraDAO prajituraDAO = cofetarieDatabase.returnDAO();
                        prajituraDAO.insertPrajitura(p);
                    }
                });
            }
        }
    }
}