package com.example.testprep04;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Carte implements Parcelable {
    private String titlu;
    private String categorie;
    private Boolean citita;
    private Date data;

    protected Carte(Parcel in) {
        titlu = in.readString();
        categorie = in.readString();
        byte tmpCitita = in.readByte();
        citita = tmpCitita == 0 ? null : tmpCitita == 1;
        data = new Date(in.readLong());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titlu);
        dest.writeString(categorie);
        dest.writeByte((byte) (citita == null ? 0 : citita ? 1 : 2));
        dest.writeLong(data.getTime());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Carte> CREATOR = new Creator<Carte>() {
        @Override
        public Carte createFromParcel(Parcel in) {
            return new Carte(in);
        }

        @Override
        public Carte[] newArray(int size) {
            return new Carte[size];
        }
    };

    @Override
    public String toString() {
        return "Carte{" +
                "titlu='" + titlu + '\'' +
                ", categorie='" + categorie + '\'' +
                ", citita=" + citita +
                ", data=" + data +
                '}';
    }

    public Carte(String titlu, String categorie, Boolean citita, Date data) {
        this.titlu = titlu;
        this.categorie = categorie;
        this.citita = citita;
        this.data = data;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Boolean getCitita() {
        return citita;
    }

    public void setCitita(Boolean citita) {
        this.citita = citita;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
