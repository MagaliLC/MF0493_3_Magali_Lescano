package com.example.mf0493_3_magali_lescano.controller;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.mf0493_3_magali_lescano.database.FilmDao;
import com.example.mf0493_3_magali_lescano.database.FilmDatabase;
import com.example.mf0493_3_magali_lescano.model.Film;

import java.util.List;

public class FilmController {
    private static FilmController controller;
    private FilmDao fFilmDao;

    private FilmController(Context context) {
        Context appContext = context.getApplicationContext();
        FilmDatabase database = Room.databaseBuilder(appContext, FilmDatabase.class, "film").allowMainThreadQueries().build();
        fFilmDao = database.getFilmDao();
    }

    public static FilmController get(Context context) {

        if (controller == null) {
            controller = new FilmController(context);
        }
        return controller;
    }

    public List<Film> getFilms() {
        return fFilmDao.getFilms();
    }

    public Film getFilm(String uuid) {
        return fFilmDao.getFilm(uuid);
    }

    public void deleteFilm(Film film) {
        fFilmDao.deleteFilm(film);
    }

    public void updateFilm(Film film) {
        fFilmDao.updateFilm(film);
    }

    public void createFilm(Film film) {
        fFilmDao.addFilm(film);
    }
}



