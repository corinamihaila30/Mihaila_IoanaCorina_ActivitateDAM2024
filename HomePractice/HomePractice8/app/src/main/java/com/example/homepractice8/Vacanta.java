package com.example.homepractice8;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

@Entity(tableName = "vacanta")
public class Vacanta implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    @NotNull
    private Integer id;
    private String destinatie;
    private Date data;
    private Float pret;

    public Vacanta(Integer id, String destinatie, Date data, Float pret) {
        this.id = id;
        this.destinatie = destinatie;
        this.data = data;
        this.pret = pret;
    }

    protected Vacanta(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        destinatie = in.readString();
        if (in.readByte() == 0) {
            pret = null;
        } else {
            pret = in.readFloat();
        }
        data = new Date(in.readLong());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(destinatie);
        if (pret == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(pret);
        }
        dest.writeLong(data.getTime());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Vacanta> CREATOR = new Creator<Vacanta>() {
        @Override
        public Vacanta createFromParcel(Parcel in) {
            return new Vacanta(in);
        }

        @Override
        public Vacanta[] newArray(int size) {
            return new Vacanta[size];
        }
    };

    @Override
    public String toString() {
        return "Vacanta{" +
                "id=" + id +
                ", destinatie='" + destinatie + '\'' +
                ", data=" + data +
                ", pret=" + pret +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDestinatie() {
        return destinatie;
    }

    public void setDestinatie(String destinatie) {
        this.destinatie = destinatie;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Float getPret() {
        return pret;
    }

    public void setPret(Float pret) {
        this.pret = pret;
    }
}
