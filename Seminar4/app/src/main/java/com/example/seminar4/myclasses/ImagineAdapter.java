package com.example.seminar4.myclasses;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.seminar4.R;

import java.util.ArrayList;

public class ImagineAdapter extends BaseAdapter {
    Context ctx;
    ArrayList<ImaginiDomeniu> listaImag;
    Integer idTemplate;

    public ImagineAdapter(Context ctx, ArrayList<ImaginiDomeniu> listaImag, Integer idTemplate) {
        this.ctx = ctx;
        this.listaImag = listaImag;
        this.idTemplate = idTemplate;
    }

    @Override
    public int getCount() {
        return listaImag.size();
    }

    @Override
    public Object getItem(int i) {
        return listaImag.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=LayoutInflater.from(ctx);
        View v = inflater.inflate(idTemplate,viewGroup,false);
        ImageView imagine=v.findViewById(R.id.template_imagine);
        TextView text=v.findViewById(R.id.template_text);

        imagine.setImageBitmap(listaImag.get(i).getImagine());
        text.setText(listaImag.get(i).getTextAfisat());
        return v;
    }
}
