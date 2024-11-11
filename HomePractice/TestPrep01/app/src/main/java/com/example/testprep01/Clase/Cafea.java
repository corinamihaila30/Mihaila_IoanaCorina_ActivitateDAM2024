package com.example.testprep01.Clase;

import android.os.Parcel;
import android.os.Parcelable;

public class Cafea implements Parcelable {
    private String denumire;
    private Float pret;
    private Boolean cofeina;

    protected Cafea(Parcel in) {
        denumire = in.readString();
        if (in.readByte() == 0) {
            pret = null;
        } else {
            pret = in.readFloat();
        }
        byte tmpCofeina = in.readByte();
        cofeina = tmpCofeina == 0 ? null : tmpCofeina == 1;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(denumire);
        if (pret == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(pret);
        }
        dest.writeByte((byte) (cofeina == null ? 0 : cofeina ? 1 : 2));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Cafea> CREATOR = new Creator<Cafea>() {
        @Override
        public Cafea createFromParcel(Parcel in) {
            return new Cafea(in);
        }

        @Override
        public Cafea[] newArray(int size) {
            return new Cafea[size];
        }
    };

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Float getPret() {
        return pret;
    }

    public void setPret(Float pret) {
        this.pret = pret;
    }

    public Boolean getCofeina() {
        return cofeina;
    }

    public void setCofeina(Boolean cofeina) {
        this.cofeina = cofeina;
    }

    public Cafea(String denumire, Float pret, Boolean cofeina) {
        this.denumire = denumire;
        this.pret = pret;
        this.cofeina = cofeina;
    }

    @Override
    public String toString() {
        return "Cafea{" +
                "denumire='" + denumire + '\'' +
                ", pret=" + pret +
                ", cofeina=" + cofeina +
                '}';
    }
}
