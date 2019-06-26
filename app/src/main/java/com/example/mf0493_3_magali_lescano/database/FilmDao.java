package com.example.mf0493_3_magali_lescano.database;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import com.example.mf0493_3_magali_lescano.model.Film;

public interface FilmDao {
    @Query("SELECT * FROM film")
    List<Film> getFilms();

    @Query("SELECT * FROM film where id like :uuid")
    Film getFilm(String uuid);

    @Insert
    void addFilm(Film f);

    @Delete
    void deleteFilm(Film f);

    @Update
    void updateFilm(Film f);
}
