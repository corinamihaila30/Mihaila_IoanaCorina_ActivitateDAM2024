package com.example.homepractice8;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.util.Date;
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
                EditText id =findViewById(R.id.main2_id);
                EditText destinatie=findViewById(R.id.main2_destinatie);
                DatePicker data=findViewById(R.id.main2_data);
                EditText pret=findViewById(R.id.main2_pret);

                Integer idI = Integer.parseInt(id.getText().toString());
                String destinatieS= destinatie.getText().toString();
                Float pretF= Float.parseFloat(pret.getText().toString());
                Integer day = data.getDayOfMonth();
                Integer month = data.getMonth();
                Integer year=data.getYear();
                Date date=new Date(day,month,year);
                Vacanta v=new Vacanta(idI,destinatieS,date,pretF);
                Executor executor= Executors.newSingleThreadExecutor();
                Handler handler=new Handler(Looper.getMainLooper());
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        AgendaDatabase agendaDatabase= Room.databaseBuilder(getApplicationContext(), AgendaDatabase.class,"agenda").build();
                        VacantaDAO vacantaDAO = agendaDatabase.returnDAO();
                        vacantaDAO.insertVacanta(v);
                    }
                });
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent();
                        intent.putExtra("vacanta",v);
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                });
            }
        });
    }
}