package com.example.homepractice13;

import android.graphics.Bitmap;

public class Imagine {
    private String name;
    private Bitmap img;
    private String link;

    public Imagine(String name, Bitmap img, String link) {
        this.name = name;
        this.img = img;
        this.link = link;
    }

    @Override
    public String toString() {
        return "Imagine{" +
                "name='" + name + '\'' +
                ", img=" + img +
                ", link='" + link + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
