package com.example.homepractice10;

import android.content.Intent;
import android.content.SharedPreferences;
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

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
        Button btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText denumire = findViewById(R.id.main2_denumire);
                EditText pret = findViewById(R.id.main2_pret);
                RadioButton beginner=findViewById(R.id.main2_beginner);

                String denumireS = denumire.getText().toString();
                Float pretF = Float.parseFloat(pret.getText().toString());
                Boolean forBeginnerB = beginner.isChecked();
                Curs c=new Curs(denumireS,pretF,forBeginnerB);
                Executor executor= Executors.newSingleThreadExecutor();
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        FileOutputStream fos = null;
                        try {
                            FileWriter fw=new FileWriter(new File(getFilesDir(), "file.txt"));
                            fw.write(c.toString());
                            fw.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                Intent intent= new Intent();
                intent.putExtra("curs",c);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}