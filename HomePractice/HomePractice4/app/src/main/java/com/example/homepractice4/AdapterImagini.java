package com.example.homepractice4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.contentcapture.ContentCaptureCondition;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class AdapterImagini extends BaseAdapter {
    Context ctx;
    ArrayList<Caine> listaCaini;
    Integer id;

    @Override
    public int getCount() {
        return listaCaini.size();
    }

    @Override
    public Object getItem(int i) {
        return listaCaini.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public AdapterImagini(Context ctx, ArrayList<Caine> listaCaini, Integer id) {
        this.ctx = ctx;
        this.listaCaini = listaCaini;
        this.id = id;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= LayoutInflater.from(ctx);
        View v = inflater.inflate(id,viewGroup,false);
        TextView text1 = v.findViewById(R.id.adapter_text1);
        ImageView img = v.findViewById(R.id.adapter_img);
        TextView text2 = v.findViewById(R.id.adapter_text2);
        text1.setText(listaCaini.get(i).getNume());
        img.setImageBitmap(listaCaini.get(i).getImagine());
        text2.setText(listaCaini.get(i).getLink());
        return v;

    }
}
