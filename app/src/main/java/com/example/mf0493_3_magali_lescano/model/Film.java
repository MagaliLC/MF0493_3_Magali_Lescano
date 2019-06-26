package com.example.mf0493_3_magali_lescano.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.UUID;

@Entity(tableName = "film")
public class Film {
    @PrimaryKey
    @NonNull
    String id;
    String title;
    String description;
    int publicationYear;
    int rating;
    String imageUrl;

    public Film(String title, String description, int publicationYear, int rating, String imageUrl) {
        id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.publicationYear = publicationYear;
        this.rating = rating;
        this.imageUrl = imageUrl;
    }

    public Film() {
        id = UUID.randomUUID().toString();
    }

    @NonNull
    public String getId() {
        return id;
    }


    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}


