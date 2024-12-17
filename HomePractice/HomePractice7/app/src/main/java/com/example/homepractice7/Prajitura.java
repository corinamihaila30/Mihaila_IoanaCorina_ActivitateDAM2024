package com.example.homepractice7;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

import javax.annotation.processing.Generated;

@Entity(tableName = "prajitura")
public class Prajitura implements Parcelable {

    @PrimaryKey
    @NotNull
    private String nume;
    private Boolean vegan;
    private Integer stoc;
    private Date data;

    public Prajitura(String nume, Boolean vegan, Integer stoc, Date data) {
        this.nume = nume;
        this.vegan = vegan;
        this.stoc = stoc;
        this.data = data;
    }

    protected Prajitura(Parcel in) {
        nume = in.readString();
        byte tmpVegan = in.readByte();
        vegan = tmpVegan == 0 ? null : tmpVegan == 1;
        if (in.readByte() == 0) {
            stoc = null;
        } else {
            stoc = in.readInt();
        }
        data = new Date(in.readLong());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nume);
        dest.writeByte((byte) (vegan == null ? 0 : vegan ? 1 : 2));
        if (stoc == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(stoc);
        }
        dest.writeLong(data.getTime());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Prajitura> CREATOR = new Creator<Prajitura>() {
        @Override
        public Prajitura createFromParcel(Parcel in) {
            return new Prajitura(in);
        }

        @Override
        public Prajitura[] newArray(int size) {
            return new Prajitura[size];
        }
    };

    @Override
    public String toString() {
        return "Prajitura{" +
                "nume='" + nume + '\'' +
                ", vegan=" + vegan +
                ", stoc=" + stoc +
                ", data=" + data +
                '}';
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

    public Integer getStoc() {
        return stoc;
    }

    public void setStoc(Integer stoc) {
        this.stoc = stoc;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
