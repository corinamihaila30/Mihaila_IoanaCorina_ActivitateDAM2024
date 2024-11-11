package com.example.testprep03;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterPersonalizat extends BaseAdapter {
    Context ctx;
    ArrayList<Rezervare> listaR;
    Integer idTemplate;

    public AdapterPersonalizat(Context ctx, Integer idTemplate, ArrayList<Rezervare> listaR) {
        this.ctx = ctx;
        this.idTemplate = idTemplate;
        this.listaR = listaR;
    }

    @Override
    public int getCount() {
        return listaR.size();
    }

    @Override
    public Object getItem(int i) {
        return listaR.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(idTemplate,viewGroup,false);
        TextView locatie = v.findViewById(R.id.LayoutTemplatetext1);
        TextView pret = v.findViewById(R.id.LayoutTemplatetext2);
        TextView nrzile = v.findViewById(R.id.LayoutTemplatetext3);
        TextView data = v.findViewById(R.id.LayoutTemplatetext4);

        locatie.setText(listaR.get(i).getLocatie());
        pret.setText(listaR.get(i).getPret().toString());
        nrzile.setText(listaR.get(i).getNrzile().toString());
        data.setText(listaR.get(i).getData().toString());

        return v;
    }
}
