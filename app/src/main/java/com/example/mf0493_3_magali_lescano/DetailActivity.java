package com.example.mf0493_3_magali_lescano;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mf0493_3_magali_lescano.controller.FilmController;
import com.example.mf0493_3_magali_lescano.model.Film;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    ArrayList<Film> films;
    FilmController controller;
    String personId;
    TextView tv_title, tv_description, tv_rating, tv_year, tv_film_img;
    private Film f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        controller = FilmController.get(this);

        personId = getIntent().getStringExtra("film_id");

        tv_title = findViewById(R.id.tv_title);
        tv_description = findViewById(R.id.tv_description);
        tv_rating = findViewById(R.id.tv_rating);
        tv_year = findViewById(R.id.tv_year);
        tv_film_img = findViewById(R.id.tv_films_url);

        getFilm(personId);
    }

    private void getFilm(String filmId) {
        f = controller.getFilm(filmId);
        loadFilms();

    }

    private void loadFilms() {
        tv_title.setText(f.getTitle());
        tv_description.setText(f.getDescription());
        tv_rating.setText(String.valueOf(f.getRating()));
        tv_year.setText(String.valueOf(f.getPublicationYear()));
    }
}

