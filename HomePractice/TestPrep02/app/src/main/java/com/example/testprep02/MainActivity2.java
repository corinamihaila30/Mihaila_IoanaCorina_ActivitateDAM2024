package com.example.testprep02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
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

        Button btn1 = findViewById(R.id.act2buton1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                EditText nume = findViewById(R.id.act2nume);
                EditText pret = findViewById(R.id.act2pret);
                DatePicker data = findViewById(R.id.act2date);
                Spinner spinner = findViewById(R.id.act2spinner);

                String numeS = nume.getText().toString();
                Double pretD = Double.parseDouble(pret.getText().toString());

                Integer year  = data.getYear();
                Integer month = data.getMonth();
                Integer day =data.getDayOfMonth();

                Date dataD=new Date(year,month,day);

                String spinnerS = spinner.getSelectedItem().toString();

                AirlineTicket a=new AirlineTicket(numeS,pretD,dataD,spinnerS);
                Toast.makeText(getApplicationContext(),a.toString(),Toast.LENGTH_LONG).show();
                intent.putExtra("ticket", a);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}