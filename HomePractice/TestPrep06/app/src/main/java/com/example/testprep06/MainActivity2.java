package com.example.testprep06;

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

        Button btn=findViewById(R.id.Act2btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                EditText nume=findViewById(R.id.Act2nume);
                EditText pret=findViewById(R.id.Act2pret);
                Spinner categorie=findViewById(R.id.Act2categorie);
                DatePicker data=findViewById(R.id.Act2data);

                String numeS = nume.getText().toString();
                Double pretD = Double.parseDouble(pret.getText().toString());
                String categorieS = categorie.getSelectedItem().toString();
                Integer year = data.getYear();
                Integer month =data.getMonth();
                Integer day=data.getDayOfMonth();
                Date dataD=new Date(year,month,day);

                Bilet b=new Bilet(numeS,pretD,categorieS,dataD);
                //Toast.makeText(getApplicationContext(),b.toString(),Toast.LENGTH_LONG).show();
                Bundle bundle = new Bundle();
                bundle.putParcelable("bilet",b);
                intent.putExtras(bundle);
                //intent.putExtra("bilet",b);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}