package com.nuhkoca.android.recyclerviewoverflowmenudemo.model;

/**
 * Created by nuhkoca on 28.11.2017.
 */

public class SimpleDataModel {
    private int imageId;
    private int title, description, author, date;

    public SimpleDataModel(int imageId, int title, int description, int author, int date) {
        this.imageId = imageId;
        this.title = title;
        this.description = description;
        this.author = author;
        this.date = date;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
