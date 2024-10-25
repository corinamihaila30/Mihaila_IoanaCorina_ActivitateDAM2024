package com.example.seminar4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.seminar4.myclasses.Camera;

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

        Button btn = findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText den = findViewById(R.id.denumire);
                EditText pret=findViewById(R.id.pretCamera);
                EditText nr=findViewById(R.id.nrCamera);
                EditText tip= findViewById(R.id.tipCamera);
                String denumireS = den.getText().toString();
                String tipS = tip.getText().toString();
                Integer pretInt = Integer.parseInt(pret.getText().toString());
                Integer nrInt = Integer.parseInt(nr.getText().toString());
                CheckBox check = findViewById(R.id.Ocupata);
                Boolean ocupat = check.isChecked();
                Camera c=new Camera(denumireS,ocupat,nrInt,pretInt,tipS);
                Toast.makeText(getApplicationContext(),c.toString(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }


}