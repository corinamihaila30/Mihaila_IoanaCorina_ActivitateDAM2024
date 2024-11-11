package com.example.testprep03;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Rezervare implements Parcelable{
    private String locatie;
    private Double pret;
    private Integer nrzile;
    private Date data;

    protected Rezervare(Parcel in) {
        locatie = in.readString();
        if (in.readByte() == 0) {
            pret = null;
        } else {
            pret = in.readDouble();
        }
        if (in.readByte() == 0) {
            nrzile = null;
        } else {
            nrzile = in.readInt();
        }
        data = new Date(in.readLong());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(locatie);
        if (pret == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(pret);
        }
        if (nrzile == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(nrzile);
            dest.writeLong(data.getTime());
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Rezervare> CREATOR = new Creator<Rezervare>() {
        @Override
        public Rezervare createFromParcel(Parcel in) {
            return new Rezervare(in);
        }

        @Override
        public Rezervare[] newArray(int size) {
            return new Rezervare[size];
        }
    };

    @Override
    public String toString() {
        return "Rezervare{" +
                "locatie='" + locatie + '\'' +
                ", pret=" + pret +
                ", nrzile=" + nrzile +
                ", data=" + data +
                '}';
    }

    public Rezervare(String locatie, Double pret, Integer nrzile, Date data) {
        this.locatie = locatie;
        this.pret = pret;
        this.nrzile = nrzile;
        this.data = data;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public Double getPret() {
        return pret;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    public Integer getNrzile() {
        return nrzile;
    }

    public void setNrzile(Integer nrzile) {
        this.nrzile = nrzile;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
