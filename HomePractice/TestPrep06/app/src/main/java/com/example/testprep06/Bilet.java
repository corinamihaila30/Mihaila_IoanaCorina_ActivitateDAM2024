package com.example.testprep06;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Bilet implements Parcelable {
    private String nume;
    private Double pret;
    private String categorie;
    private Date data;

    protected Bilet(Parcel in) {
        nume = in.readString();
        if (in.readByte() == 0) {
            pret = null;
        } else {
            pret = in.readDouble();
        }
        categorie = in.readString();
        data = new Date(in.readLong());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nume);
        if (pret == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(pret);
        }
        dest.writeString(categorie);
        dest.writeLong(data.getTime());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Bilet> CREATOR = new Creator<Bilet>() {
        @Override
        public Bilet createFromParcel(Parcel in) {
            return new Bilet(in);
        }

        @Override
        public Bilet[] newArray(int size) {
            return new Bilet[size];
        }
    };

    @Override
    public String toString() {
        return "Bilet{" +
                "nume='" + nume + '\'' +
                ", pret=" + pret +
                ", categorie='" + categorie + '\'' +
                ", data=" + data +
                '}';
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Double getPret() {
        return pret;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Bilet(String nume, Double pret, String categorie, Date data) {
        this.nume = nume;
        this.pret = pret;
        this.categorie = categorie;
        this.data = data;
    }
}
