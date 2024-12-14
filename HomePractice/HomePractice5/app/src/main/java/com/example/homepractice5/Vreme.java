package com.example.homepractice5;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.jar.Pack200;

public class Vreme implements Parcelable {
    private Double longitudine;
    private Double latitudine;

    public Vreme(Double longitudine, Double latitudine) {
        this.longitudine = longitudine;
        this.latitudine = latitudine;
    }

    protected Vreme(Parcel in) {
        if (in.readByte() == 0) {
            longitudine = null;
        } else {
            longitudine = in.readDouble();
        }
        if (in.readByte() == 0) {
            latitudine = null;
        } else {
            latitudine = in.readDouble();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (longitudine == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(longitudine);
        }
        if (latitudine == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(latitudine);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Vreme> CREATOR = new Creator<Vreme>() {
        @Override
        public Vreme createFromParcel(Parcel in) {
            return new Vreme(in);
        }

        @Override
        public Vreme[] newArray(int size) {
            return new Vreme[size];
        }
    };

    @Override
    public String toString() {
        return "Vreme{" +
                "longitudine=" + longitudine +
                ", latitudine=" + latitudine +
                '}';
    }

    public Double getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(Double longitudine) {
        this.longitudine = longitudine;
    }

    public Double getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(Double latitudine) {
        this.latitudine = latitudine;
    }
}
