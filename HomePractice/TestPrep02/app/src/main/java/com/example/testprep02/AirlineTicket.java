package com.example.testprep02;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class AirlineTicket implements Parcelable {
    private String nume;
    private Double pret;
    private Date data;
    private String categorie;

    public AirlineTicket(String nume, Double pret, Date data, String categorie) {
        this.nume = nume;
        this.pret = pret;
        this.data = data;
        this.categorie = categorie;
    }

    protected AirlineTicket(Parcel in) {
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

    public static final Creator<AirlineTicket> CREATOR = new Creator<AirlineTicket>() {
        @Override
        public AirlineTicket createFromParcel(Parcel in) {
            return new AirlineTicket(in);
        }

        @Override
        public AirlineTicket[] newArray(int size) {
            return new AirlineTicket[size];
        }
    };

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "AirlineTicket{" +
                "nume='" + nume + '\'' +
                ", pret=" + pret +
                ", data=" + data +
                ", categorie='" + categorie + '\'' +
                '}';
    }

}
