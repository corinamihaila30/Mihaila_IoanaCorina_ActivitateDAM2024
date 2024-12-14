package com.example.homepractice3;

import android.os.Parcel;
import android.os.Parcelable;

public class Telefon implements Parcelable {
    private Boolean brand;
    private Integer stoc;

    public Telefon(Boolean brand, Integer stoc) {
        this.brand = brand;
        this.stoc = stoc;
    }

    protected Telefon(Parcel in) {
        byte tmpBrand = in.readByte();
        brand = tmpBrand == 0 ? null : tmpBrand == 1;
        if (in.readByte() == 0) {
            stoc = null;
        } else {
            stoc = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (brand == null ? 0 : brand ? 1 : 2));
        if (stoc == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(stoc);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Telefon> CREATOR = new Creator<Telefon>() {
        @Override
        public Telefon createFromParcel(Parcel in) {
            return new Telefon(in);
        }

        @Override
        public Telefon[] newArray(int size) {
            return new Telefon[size];
        }
    };

    @Override
    public String toString() {
        return "Telefon{" +
                "brand=" + brand +
                ", stoc=" + stoc +
                '}';
    }

    public Boolean getBrand() {
        return brand;
    }

    public void setBrand(Boolean brand) {
        this.brand = brand;
    }

    public Integer getStoc() {
        return stoc;
    }

    public void setStoc(Integer stoc) {
        this.stoc = stoc;
    }
}
