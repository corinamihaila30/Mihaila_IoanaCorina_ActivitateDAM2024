package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.seminar4.myclasses.Camera;
import com.example.seminar4.myclasses.CameraAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListaCamereRezervate extends AppCompatActivity {
    private List<Camera> lisCamere = null;
    private int idModificat=0;
    private CameraAdapter adapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_camere_rezervate);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent it=getIntent();
        List<Camera> camereAniv= it.getParcelableArrayListExtra("camere");

        ListView lw=findViewById(R.id.LWcamere);
        ArrayAdapter<Camera> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,camereAniv);
        //lw.setAdapter(adapter);
        //adapter=new CameraAdapter(camereAniv,getApplicationContext(),R.layout.list_view_custom);
        lw.setAdapter(adapter);

        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), camereAniv.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
        lw.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //camereAniv.remove(i);
                //adapter.notifyDataSetChanged();
                Intent intentModif=new Intent(getApplicationContext(),MainActivity.class);
                intentModif.putExtra("camera",camereAniv.get(i));
                idModificat=1;
                startActivityForResult(intentModif,403);
                Toast.makeText(getApplicationContext(),camereAniv.get(i).toString(),Toast.LENGTH_LONG).show();
                return false;

            }
        });

    }



}