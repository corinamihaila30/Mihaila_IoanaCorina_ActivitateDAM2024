package com.example.homepractice7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

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
        Button btn=findViewById(R.id.main2_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText den = findViewById(R.id.main2_den);
                RadioButton vegan = findViewById(R.id.main2_vegan);
                EditText stoc = findViewById(R.id.main2_stoc);
                DatePicker date = findViewById(R.id.main2_data);

                String denS = den.getText().toString();
                Boolean veganB = vegan.isChecked();
                Integer stocI = Integer.parseInt(stoc.getText().toString());
                Integer day = date.getDayOfMonth();
                Integer month = date.getMonth();
                Integer year = date.getYear();
                Date data = new Date(day, month, year);
                Prajitura p = new Prajitura(denS, veganB, stocI, data);
                Intent intent = new Intent();
                intent.putExtra("prajitura", p);
                setResult(RESULT_OK, intent);
                finish();

            }
        });

    }
}