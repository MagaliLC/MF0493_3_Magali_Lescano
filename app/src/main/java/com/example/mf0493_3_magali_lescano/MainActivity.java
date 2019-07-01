package com.example.mf0493_3_magali_lescano;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.mf0493_3_magali_lescano.controller.FilmController;
import com.example.mf0493_3_magali_lescano.model.Film;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    SharedPreferences prefs;
    ListView listView;
    FilmController controller;
    FilmAdapter adapter;
    ArrayList<Film> films;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogIn();

        films = new ArrayList<Film>();
        adapter = new FilmAdapter(this, R.layout.film_row, films);
        listView = findViewById(R.id.lv_films);
        listView.setAdapter(adapter);
        controller = FilmController.get(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String filmId = films.get(position).getId();
                sendData(view, filmId);
            }
        });
    }

    private void LogIn() {
        prefs = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        boolean isLogged = prefs.getBoolean("isLogged", false);
        if (!isLogged) {
            toLogin();
        }
    }

    public void sendData(View view, String filmId) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("film_id", filmId);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getFilms();
    }

    private void toLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    private void getFilms() {
        films.clear();
        films.addAll(controller.getFilms());
        adapter.notifyDataSetChanged();
    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addFilm:
                addFilm();
                return (true);

            case R.id.inspiration:
                toInspiration();
                return (true);
        }
        return (super.onOptionsItemSelected(item));
    }

    private void addFilm() {
        Intent intent = new Intent(MainActivity.this, AddFilmActivity.class);
        startActivity(intent);
    }

    private void toInspiration() {
        Intent intent = new Intent(MainActivity.this, InspirationActivity.class);
        startActivity(intent);
    }
}
