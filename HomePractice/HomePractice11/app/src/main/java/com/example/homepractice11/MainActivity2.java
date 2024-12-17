package com.example.homepractice11;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

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
        Button btn=findViewById(R.id.main2_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText id = findViewById(R.id.main2_id);
                EditText name=findViewById(R.id.main2_nume);
                Integer idI = Integer.parseInt(id.getText().toString());
                String nameS = name.getText().toString();
                Student student=new Student(idI,nameS);
                Executor executor= Executors.newSingleThreadExecutor();
                Handler handler=new Handler(Looper.getMainLooper());
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        FacultateDatabase facultateDatabase = Room.databaseBuilder(getApplicationContext(), FacultateDatabase.class,"obiecte").build();
                        StudentDA0 studentDA0=facultateDatabase.returnDAO();
                        studentDA0.insertStudent(student);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent=new Intent();
                                intent.putExtra("student",student);
                                setResult(RESULT_OK,intent);
                                finish();
                            }
                        });
                    }
                });

            }
        });
    }
}