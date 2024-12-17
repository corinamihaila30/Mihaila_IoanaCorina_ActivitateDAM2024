package com.example.homepractice9;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
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
        Button btn=findViewById(R.id.main2_btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText denumire=findViewById(R.id.main2_denumire);
                EditText pret = findViewById(R.id.main2_pret);
                RadioButton isNew = findViewById(R.id.main2_nou);

                String denumireS =denumire.getText().toString();
                Float pretF = Float.parseFloat(pret.getText().toString());
                Boolean isNewB = isNew.isChecked();

                Haina h=new Haina(denumireS,pretF,isNewB);
                Intent intent=new Intent();
                intent.putExtra("haina",h);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}