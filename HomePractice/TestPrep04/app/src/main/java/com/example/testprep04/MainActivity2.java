package com.example.testprep04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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

        Button btn1 = findViewById(R.id.Act2btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                EditText titlu = findViewById(R.id.Act2titlu);
                Spinner categorie = findViewById(R.id.Act2Categorie);
                CheckBox citita = findViewById(R.id.Act2Citita);
                DatePicker data= findViewById(R.id.Act2Data);

                String titluS = titlu.getText().toString();
                String categorieS= categorie.getSelectedItem().toString();
                Boolean cititaB = citita.isChecked();
                Integer year = data.getYear();
                Integer month = data.getMonth();
                Integer day=data.getDayOfMonth();
                Date dataD=new Date(year,month,day);
                Carte c=new Carte(titluS,categorieS,cititaB,dataD);
                //Toast.makeText(getApplicationContext(), c.toString(), Toast.LENGTH_SHORT).show();

                intent.putExtra("carte",c);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}