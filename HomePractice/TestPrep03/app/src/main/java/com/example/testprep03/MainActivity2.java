package com.example.testprep03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;

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
        Button btn1 = findViewById(R.id.Act2btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText locatie = findViewById(R.id.Act2Text1locatie);
                EditText pret=findViewById(R.id.Act2Text2pret);
                EditText nrzile=findViewById(R.id.Act2Text3nrzile);
                DatePicker data=findViewById(R.id.Act2date);

                String locatieS= locatie.getText().toString();
                Double pretD = Double.valueOf(pret.getText().toString());
                Integer nrzileI = Integer.valueOf(nrzile.getText().toString());
                Integer year= data.getYear();
                Integer month =data.getMonth();
                Integer day =data.getDayOfMonth();
                Date dataD = new Date(year,month,day);

                Rezervare r=new Rezervare(locatieS,pretD,nrzileI,dataD);
                //Toast.makeText(getApplicationContext(),r.toString(),Toast.LENGTH_LONG).show();
                Intent intent=new Intent();
                intent.putExtra("rezervare",r);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}