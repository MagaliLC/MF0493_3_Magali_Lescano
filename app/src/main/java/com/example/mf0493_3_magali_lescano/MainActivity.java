package com.example.mf0493_3_magali_lescano;


import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


import com.example.mf0493_3_magali_lescano.controller.FilmController;
import com.example.mf0493_3_magali_lescano.model.Film;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    Activity activity = this;
    ListView listView;
    FilmController controller;
    FilmAdapter adapter;
    ArrayList<Film> films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        films = new ArrayList<Film>();
        adapter = new FilmAdapter(this, R.layout.film_row, films);
        listView = findViewById(R.id.lv_films);
        listView.setAdapter(adapter);
        controller = FilmController.get(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        getFilms();
    }

    private void getFilms() {
        films.clear();
        films.addAll(controller.getFilms());
        adapter.notifyDataSetChanged();
    }
    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addPost:
                toForm();
                return (true);
        }
        return (super.onOptionsItemSelected(item));
    }
}
