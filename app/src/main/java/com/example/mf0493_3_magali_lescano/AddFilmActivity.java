package com.example.mf0493_3_magali_lescano;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mf0493_3_magali_lescano.controller.FilmController;
import com.example.mf0493_3_magali_lescano.model.Film;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AddFilmActivity extends AppCompatActivity {
    FilmController controller;
    EditText et_title, et_description, et_year, et_rating, et_url;
    Film f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_film);

        controller = FilmController.get(this);
        et_title = findViewById(R.id.et_title);
        et_description = findViewById(R.id.et_description);
        et_year = findViewById(R.id.et_year);
        et_rating = findViewById(R.id.et_rating);
        et_url = findViewById(R.id.et_url);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void btnAddPressed(View view) {
        String title = et_title.getText().toString();
        String description = et_description.getText().toString();
        String year = et_year.getText().toString();
        String rating = et_rating.getText().toString();
        String url = et_url.getText().toString();


        if (checkFields(title, description, year, rating, url)) {
            Film f = new Film(title, description, Integer.parseInt(year), Integer.parseInt(rating), url);
            controller.createFilm(f);
            finish();
        }
    }

    private boolean checkFields(String title, String description, String year, String rating, String url) {
        boolean valid = true;

        if ("".equals(title)) {
            et_title.setError(getString(R.string.empty_field));
            valid = false;
        }
        if ("".equals(description)) {
            et_description.setError(getString(R.string.empty_field));
            valid = true;
        }
        if ("".equals(year)) {
            et_year.setError(getString(R.string.empty_field));
            valid = false;
        }
        if ("".equals(rating)) {
            et_rating.setError(getString(R.string.empty_field));
            valid = false;
        } else {
            if ((Integer.parseInt(rating) > 5) || (Integer.parseInt(rating) < 0)) {
                et_rating.setError(getString(R.string.rating_range));
                valid = false;
            }
        }
        if ("".equals(url)) {
            et_url.setError(getString(R.string.empty_field));
            valid = false;
        }
        return valid;
    }
}


