package com.example.testprep05;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Produs implements Parcelable {
    private String model;
    private Integer stoc;
    private String categorie;
    private Date data;

    protected Produs(Parcel in) {
        model = in.readString();
        if (in.readByte() == 0) {
            stoc = null;
        } else {
            stoc = in.readInt();
        }
        categorie = in.readString();
        data = new Date(in.readLong());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(model);
        if (stoc == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(stoc);
        }
        dest.writeString(categorie);
        dest.writeLong(data.getTime());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Produs> CREATOR = new Creator<Produs>() {
        @Override
        public Produs createFromParcel(Parcel in) {
            return new Produs(in);
        }

        @Override
        public Produs[] newArray(int size) {
            return new Produs[size];
        }
    };

    @Override
    public String toString() {
        return "Produs{" +
                "model='" + model + '\'' +
                ", stoc=" + stoc +
                ", categorie='" + categorie + '\'' +
                ", data=" + data +
                '}';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getStoc() {
        return stoc;
    }

    public void setStoc(Integer stoc) {
        this.stoc = stoc;
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

    public Produs(String model, Date data, String categorie, Integer stoc) {
        this.model = model;
        this.data = data;
        this.categorie = categorie;
        this.stoc = stoc;
    }
}
