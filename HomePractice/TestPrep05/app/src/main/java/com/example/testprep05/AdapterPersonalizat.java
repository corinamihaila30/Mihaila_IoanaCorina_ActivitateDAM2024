package com.example.testprep05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterPersonalizat extends BaseAdapter {
    Context ctx;
    ArrayList<Produs> listaP;
    Integer idTemplate;

    public AdapterPersonalizat(Context ctx, ArrayList<Produs> listaP, Integer idTemplate) {
        this.ctx = ctx;
        this.listaP = listaP;
        this.idTemplate = idTemplate;
    }

    @Override
    public int getCount() {
        return listaP.size();
    }

    @Override
    public Object getItem(int i) {
        return listaP.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= LayoutInflater.from(ctx);
        View v = inflater.inflate(idTemplate,viewGroup,false);

        TextView model = v.findViewById(R.id.lymodel);
        TextView stoc = v.findViewById(R.id.lystoc);
        TextView categorie = v.findViewById(R.id.lycategorie);
        TextView data = v.findViewById(R.id.lydata);

        model.setText(listaP.get(i).getModel().toString());
        stoc.setText(listaP.get(i).getStoc().toString());
        categorie.setText(listaP.get(i).getCategorie().toString());
        data.setText(listaP.get(i).getData().toString());
        return v;
    }


}
