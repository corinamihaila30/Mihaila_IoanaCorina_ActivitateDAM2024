package com.example.homepractice2;

import android.graphics.Bitmap;

public class Imagine {
    private String text;
    private Bitmap img;
    private String link;

    public Imagine(String text, Bitmap img, String link) {
        this.text = text;
        this.img = img;
        this.link = link;
    }

    @Override
    public String toString() {
        return "Imagine{" +
                "text='" + text + '\'' +
                ", img=" + img +
                ", link='" + link + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
