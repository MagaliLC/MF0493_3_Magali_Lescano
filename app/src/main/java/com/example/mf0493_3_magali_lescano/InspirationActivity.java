package com.example.mf0493_3_magali_lescano;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mf0493_3_magali_lescano.model.GhibliFilm;
import com.example.mf0493_3_magali_lescano.retrofit.MyService;
import com.example.mf0493_3_magali_lescano.retrofit.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InspirationActivity extends AppCompatActivity {
    ListView listView;
    InspirationAdapter adapter;
    ArrayList<GhibliFilm> ghibliFilms;
    Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspiration);

        ghibliFilms = new ArrayList<GhibliFilm>();
        adapter = new InspirationAdapter(activity, R.layout.inspiration_row, ghibliFilms);
        listView = findViewById(R.id.lv_ghibli);
        listView.setAdapter(adapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getFilmsFromRetrofit();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void getFilmsFromRetrofit() {
        MyService service = RetrofitClientInstance.getRetrofitInstance().create(MyService.class);
        Call<List<GhibliFilm>> call = service.filmList();
        call.enqueue(new Callback<List<GhibliFilm>>() {

            @Override
            public void onResponse(Call<List<GhibliFilm>> call, Response<List<GhibliFilm>> response) {
                ghibliFilms.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<GhibliFilm>> call, Throwable t) {
                Toast.makeText(activity, R.string.error, Toast.LENGTH_LONG).show();
            }
        });
    }
}

