package com.example.homepractice10;

import android.os.Parcel;
import android.os.Parcelable;

public class Curs implements Parcelable {
    private String denumire;
    private Float pret;
    private Boolean forBeginner;

    public Curs(String denumire, Float pret, Boolean forBeginner) {
        this.denumire = denumire;
        this.pret = pret;
        this.forBeginner = forBeginner;
    }

    protected Curs(Parcel in) {
        denumire = in.readString();
        if (in.readByte() == 0) {
            pret = null;
        } else {
            pret = in.readFloat();
        }
        byte tmpForBeginner = in.readByte();
        forBeginner = tmpForBeginner == 0 ? null : tmpForBeginner == 1;
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
        dest.writeByte((byte) (forBeginner == null ? 0 : forBeginner ? 1 : 2));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Curs> CREATOR = new Creator<Curs>() {
        @Override
        public Curs createFromParcel(Parcel in) {
            return new Curs(in);
        }

        @Override
        public Curs[] newArray(int size) {
            return new Curs[size];
        }
    };

    @Override
    public String toString() {
        return "Curs{" +
                "denumire='" + denumire + '\'' +
                ", pret=" + pret +
                ", forBeginner=" + forBeginner +
                '}';
    }

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

    public Boolean getForBeginner() {
        return forBeginner;
    }

    public void setForBeginner(Boolean forBeginner) {
        this.forBeginner = forBeginner;
    }
}
