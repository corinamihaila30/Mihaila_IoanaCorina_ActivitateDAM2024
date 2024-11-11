package com.example.testprep01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.testprep01.Clase.Cafea;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button = findViewById(R.id.Act3Buton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText denumire = findViewById(R.id.Act3Denumire);
                EditText pret = findViewById(R.id.Act3Pret);
                CheckBox checkCofeina = findViewById(R.id.Act3Cofeina);

                String denS=denumire.getText().toString();
                Float pretF= Float.valueOf(pret.getText().toString());
                Boolean cofeinaB = checkCofeina.isChecked();

                Cafea c=new Cafea(denS,pretF,cofeinaB);
                Toast.makeText(getApplicationContext(),c.toString(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.putExtra("cafea",c);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}