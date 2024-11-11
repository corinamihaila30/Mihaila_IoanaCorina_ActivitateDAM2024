package com.example.seminar4.myclasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.seminar4.R;

import java.util.List;

public class CameraAdapter extends BaseAdapter {
    private List<Camera> listaCamere = null;
    private Context ctx;
    private int resursaLayout;

    public CameraAdapter(List<Camera> listaCamere, Context ctx, int resursaLayout) {
        this.listaCamere = listaCamere;
        this.ctx = ctx;
        this.resursaLayout = resursaLayout;
    }

    @Override
    public int getCount() {
        return listaCamere.size();
    }

    @Override
    public Object getItem(int i) {
        return listaCamere.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=LayoutInflater.from(ctx);
        View v=inflater.inflate(resursaLayout,viewGroup,false);
        EditText den = v.findViewById(R.id.denumire);
        EditText pret=v.findViewById(R.id.pretCamera);
        EditText nr=v.findViewById(R.id.nrCamera);
        EditText tip= v.findViewById(R.id.tipCamera);
        CheckBox check = v.findViewById(R.id.Ocupata);
        Camera camera = (Camera) getItem(i);

        den.setText(camera.getDenumireCladire());
        pret.setText(camera.getPretCamera());
        nr.setText(camera.getNrCamera());
        tip.setText(camera.getTipCamera());
        check.setChecked(camera.getOcupat());

        return v;
    }
}
