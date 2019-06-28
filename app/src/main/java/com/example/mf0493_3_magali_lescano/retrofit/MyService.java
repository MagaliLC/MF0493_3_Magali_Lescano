package com.example.mf0493_3_magali_lescano.retrofit;

import com.example.mf0493_3_magali_lescano.model.GhibliFilm;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyService {
    @GET("films/")
    Call<List<GhibliFilm>> filmList();

    @GET("films/{film_id}")
    Call<GhibliFilm> getFilm(@Path("film_id") String film_id);
}
