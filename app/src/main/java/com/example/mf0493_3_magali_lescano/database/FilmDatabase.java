package com.example.mf0493_3_magali_lescano.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.mf0493_3_magali_lescano.model.Film;

@Database(entities = {Film.class}, version = 1)
public abstract class FilmDatabase extends RoomDatabase {
    public abstract FilmDao getFilmDao();
}



