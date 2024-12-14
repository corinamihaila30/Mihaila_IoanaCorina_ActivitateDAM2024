package com.example.homepractice3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        Button btn1=findViewById(R.id.act2_btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                RadioButton brand=findViewById(R.id.act2_brand);
                EditText stocul=findViewById(R.id.act2_stoc);
                Boolean brandB= brand.isChecked();
                Integer stocI = Integer.parseInt(stocul.getText().toString());
                Telefon tel=new Telefon(brandB,stocI);
                //Log.i("main2",tel.toString());
                intent.putExtra("telefon",tel);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}