package com.example.mf0493_3_magali_lescano;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mf0493_3_magali_lescano.R;

import java.util.ArrayList;

import com.example.mf0493_3_magali_lescano.model.Film;

public class FilmAdapter extends ArrayAdapter<Film> {

    int layoutResourceId;
    Context context;
    ArrayList<Film> data;

    public FilmAdapter(Context context, int layoutResourceId, ArrayList<Film> data) {
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

        TextView tv_title = row.findViewById(R.id.tv_title);
        TextView tv_rating = row.findViewById(R.id.tv_rating);


        Film f = data.get(position);
        tv_title.setText(f.getTitle());
        tv_rating.setText(String.valueOf(f.getRating()));
        int rating = f.getRating();
        setRatingColor(rating, tv_rating, tv_title);
        return row;
    }

    private void setRatingColor(int rating, TextView tv_rating, TextView tv_title) {
        if (rating < 2) {
            tv_title.setTextColor(context.getResources().getColor(R.color.red));
            tv_rating.setTextColor(context.getResources().getColor(R.color.red));


        } else if (rating < 4) {
            tv_title.setTextColor(context.getResources().getColor(R.color.black));
            tv_rating.setTextColor(context.getResources().getColor(R.color.black));

        } else if (rating < 6) {
            tv_title.setTextColor(context.getResources().getColor(R.color.green));
            tv_rating.setTextColor(context.getResources().getColor(R.color.green));
        }

    }
}





