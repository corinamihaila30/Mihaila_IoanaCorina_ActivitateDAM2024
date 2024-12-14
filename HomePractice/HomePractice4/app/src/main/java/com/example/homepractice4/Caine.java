package com.example.homepractice4;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class Caine implements Parcelable {

    private String nume;
    private Bitmap imagine;
    private String link;
    public Caine(String nume, Bitmap imagine, String link) {
        this.nume = nume;
        this.imagine = imagine;
        this.link = link;
    }

    protected Caine(Parcel in) {
        nume = in.readString();
        imagine = in.readParcelable(Bitmap.class.getClassLoader());
        link = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nume);
        dest.writeParcelable(imagine, flags);
        dest.writeString(link);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Caine> CREATOR = new Creator<Caine>() {
        @Override
        public Caine createFromParcel(Parcel in) {
            return new Caine(in);
        }

        @Override
        public Caine[] newArray(int size) {
            return new Caine[size];
        }
    };

    @Override
    public String toString() {
        return "Caine{" +
                "nume='" + nume + '\'' +
                ", imagine=" + imagine +
                ", link='" + link + '\'' +
                '}';
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Bitmap getImagine() {
        return imagine;
    }

    public void setImagine(Bitmap imagine) {
        this.imagine = imagine;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


}
