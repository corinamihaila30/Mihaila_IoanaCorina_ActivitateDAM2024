package com.example.seminar4.myclasses;

import android.graphics.Bitmap;

public class ImaginiDomeniu {
    private String textAfisat;
    private Bitmap imagine;
    private String link;


    public String getTextAfisat() {
        return textAfisat;
    }

    public void setTextAfisat(String textAfisat) {
        this.textAfisat = textAfisat;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Bitmap getImagine() {
        return imagine;
    }

    public void setImagine(Bitmap imagine) {
        this.imagine = imagine;
    }

    public ImaginiDomeniu(String textAfisat, String link, Bitmap imagine) {
        this.textAfisat = textAfisat;
        this.link = link;
        this.imagine = imagine;
    }
}
