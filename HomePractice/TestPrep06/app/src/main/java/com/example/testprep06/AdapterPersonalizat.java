package com.example.testprep06;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterPersonalizat extends BaseAdapter {
    Context ctx;
    ArrayList<Bilet> listaB;

    public AdapterPersonalizat(Context ctx, ArrayList<Bilet> listaB, Integer idTemplate) {
        this.ctx = ctx;
        this.listaB = listaB;
        this.idTemplate = idTemplate;
    }

    Integer idTemplate;
    @Override
    public int getCount() {
        return listaB.size();
    }

    @Override
    public Object getItem(int i) {
        return listaB.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(idTemplate,viewGroup,false);
        TextView nume= v.findViewById(R.id.main3nume);
        TextView pret= v.findViewById(R.id.main3pret);
        TextView categorie= v.findViewById(R.id.main3categorie);
        TextView data= v.findViewById(R.id.main3data);

        nume.setText(listaB.get(i).getNume());
        pret.setText(listaB.get(i).getPret().toString());
        categorie.setText(listaB.get(i).getCategorie());
        data.setText(listaB.get(i).getData().toString());

        return v;
    }
}
