package com.example.homepractice2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ImagineAdapter extends BaseAdapter {
    Context ctx;
    ArrayList<Imagine> lista;
    Integer id;

    public ImagineAdapter(Context ctx, ArrayList<Imagine> lista, Integer id) {
        this.ctx = ctx;
        this.lista = lista;
        this.id = id;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(id,viewGroup, false);
        TextView text = v.findViewById(R.id.text1_template);
        ImageView img = v.findViewById(R.id.image_template);
        TextView link = v.findViewById(R.id.text2_template);

        text.setText(lista.get(i).getText());
        img.setImageBitmap(lista.get(i).getImg());
        link.setText(lista.get(i).getLink());
        return v;
    }
}
