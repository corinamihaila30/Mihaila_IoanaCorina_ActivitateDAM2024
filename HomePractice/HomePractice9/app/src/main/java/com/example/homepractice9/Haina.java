package com.example.homepractice9;

import android.os.Parcel;
import android.os.Parcelable;

public class Haina implements Parcelable {
    private String denumire;
    private Float pret;
    private Boolean isNew;

    public Haina(String denumire, Float pret, Boolean isNew) {
        this.denumire = denumire;
        this.pret = pret;
        this.isNew = isNew;
    }

    protected Haina(Parcel in) {
        denumire = in.readString();
        if (in.readByte() == 0) {
            pret = null;
        } else {
            pret = in.readFloat();
        }
        byte tmpIsNew = in.readByte();
        isNew = tmpIsNew == 0 ? null : tmpIsNew == 1;
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
        dest.writeByte((byte) (isNew == null ? 0 : isNew ? 1 : 2));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Haina> CREATOR = new Creator<Haina>() {
        @Override
        public Haina createFromParcel(Parcel in) {
            return new Haina(in);
        }

        @Override
        public Haina[] newArray(int size) {
            return new Haina[size];
        }
    };

    @Override
    public String toString() {
        return "Haina{" +
                "denumire='" + denumire + '\'' +
                ", pret=" + pret +
                ", isNew=" + isNew +
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

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }
}
