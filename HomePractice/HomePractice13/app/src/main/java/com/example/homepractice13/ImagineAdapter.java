package com.example.homepractice13;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ImagineAdapter extends BaseAdapter {
    Context ctx;
    ArrayList<Imagine> listaImagini;
    Integer id;


    @Override
    public int getCount() {
        return listaImagini.size();
    }

    public ImagineAdapter(Context ctx, ArrayList<Imagine> listaImagini, Integer id) {
        this.ctx = ctx;
        this.listaImagini = listaImagini;
        this.id = id;
    }

    @Override
    public Object getItem(int i) {
        return listaImagini.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(id,viewGroup,false);
        TextView id = v.findViewById(R.id.template_titlu);
        ImageView img = v.findViewById(R.id.template_img);
        TextView link = v.findViewById(R.id.template_link);
        id.setText(listaImagini.get(i).getName());
        img.setImageBitmap(listaImagini.get(i).getImg());
        link.setText(listaImagini.get(i).getLink());
        return v;
    }
}
