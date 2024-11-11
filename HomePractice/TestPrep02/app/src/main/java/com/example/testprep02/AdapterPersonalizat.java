package com.example.testprep02;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class AdapterPersonalizat extends BaseAdapter {
    Context ctx;
    List<AirlineTicket> listaTickets;
    Integer templateId;

    public AdapterPersonalizat(Context ctx, List<AirlineTicket> listaTickets, Integer templateId) {
        this.ctx = ctx;
        this.listaTickets = listaTickets;
        this.templateId = templateId;
    }

    @Override
    public int getCount() {
        return listaTickets.size();
    }

    @Override
    public Object getItem(int i) {
        return listaTickets.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(templateId,viewGroup,false);
        TextView nume = v.findViewById(R.id.lyTemplateText1);
        TextView pret = v.findViewById(R.id.lyTemplateText2);
        TextView data= v.findViewById(R.id.lyTemplateText3);
        TextView categorie = v.findViewById(R.id.lyTemplateText4);

        nume.setText(listaTickets.get(i).getNume());
        pret.setText(listaTickets.get(i).getPret().toString());
        data.setText(listaTickets.get(i).getData().toString());
        categorie.setText(listaTickets.get(i).getCategorie().toString());

        return v;
    }
}
