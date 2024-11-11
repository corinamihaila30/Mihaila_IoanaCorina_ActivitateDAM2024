package com.example.testprep01.Clase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.testprep01.R;

import java.util.ArrayList;

public class AdapterCafea extends BaseAdapter {
    ArrayList<Cafea> listaCafele;
    Context ctx;
    Integer idTemplate;

    public AdapterCafea(ArrayList<Cafea> listaCafele, Context ctx, Integer idTemplate) {
        this.listaCafele = listaCafele;
        this.ctx = ctx;
        this.idTemplate = idTemplate;
    }

    @Override
    public int getCount() {
        return listaCafele.size();
    }

    @Override
    public Object getItem(int i) {
        return listaCafele.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(idTemplate, viewGroup, false);
        TextView denumire = v.findViewById(R.id.adapterDenumire);
        TextView pret = v.findViewById(R.id.adapterPret);
        CheckBox check = v.findViewById(R.id.adapterCafeina);

        Cafea c = (Cafea)getItem(i);
        denumire.setText(c.getDenumire());
        pret.setText(c.getPret().toString());
        check.setChecked(c.getCofeina());


        return v;
    }
}
