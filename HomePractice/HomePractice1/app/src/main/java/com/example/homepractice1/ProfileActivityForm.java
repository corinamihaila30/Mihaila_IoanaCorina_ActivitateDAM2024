package com.example.homepractice1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.homepractice1.model.Profile;

import java.util.ArrayList;

public class ProfileActivityForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void creareObiect(View view){
        EditText profileName = findViewById(R.id.profileName);
        Spinner profileGen = findViewById(R.id.profilGen);
        EditText profileVarsta = findViewById(R.id.profileVarsta);
        CheckBox profileSportiv = findViewById(R.id.profileSportiv);
        String profileNameString = profileName.getText().toString();
        Integer profileVarstaInt = Integer.parseInt(profileVarsta.getText().toString());
        String profileGenString= profileGen.getSelectedItem().toString();
        Boolean profileSportivBool = profileSportiv.isChecked();

        Profile profile=new Profile(profileNameString,profileVarstaInt,profileGenString,profileSportivBool);
        Log.w("on",profile.toString());
    }
}