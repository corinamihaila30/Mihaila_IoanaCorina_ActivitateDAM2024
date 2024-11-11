package com.example.testprep04;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterPersonalizat extends BaseAdapter {
    Context ctx;
    ArrayList<Carte> listaC;
    Integer idTemplate;

    public AdapterPersonalizat(Context ctx, Integer idTemplate, ArrayList<Carte> listaC) {
        this.ctx = ctx;
        this.idTemplate = idTemplate;
        this.listaC = listaC;
    }

    @Override
    public int getCount() {
        return listaC.size();
    }

    @Override
    public Object getItem(int i) {
        return listaC.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= LayoutInflater.from(ctx);
        View v = inflater.inflate(idTemplate,viewGroup,false);
        TextView titlu = v.findViewById(R.id.lytitlu);
        TextView categorie = v.findViewById(R.id.lycategorie);
        TextView citita = v.findViewById(R.id.lycitita);
        TextView data = v.findViewById(R.id.lydata);
        Carte c = listaC.get(i);

        titlu.setText(c.getTitlu().toString());
        categorie.setText(c.getCategorie().toString());
        citita.setText(c.getCitita().toString());
        data.setText(c.getData().toString());

        return v;
    }
}
