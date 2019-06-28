package com.example.mf0493_3_magali_lescano;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mf0493_3_magali_lescano.model.GhibliFilm;

import java.util.ArrayList;

public class InspirationAdapter extends ArrayAdapter<GhibliFilm> {
    int layoutResourceId;
    Context context;
    ArrayList<GhibliFilm> data;

    public InspirationAdapter(Context context, int layoutResourceId, ArrayList<GhibliFilm> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);

        TextView tv_title = row.findViewById(R.id.tv_ghibli);

        GhibliFilm g = data.get(position);
        tv_title.setText(g.getTitle());
        return row;
    }
}







