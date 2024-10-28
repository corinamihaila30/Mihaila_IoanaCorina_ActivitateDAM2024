package com.example.seminar4.myclasses;

import android.os.Parcel;
import android.os.Parcelable;

public class Camera implements Parcelable {
    private String denumireCladire;
    private String tipCamera;
    private Integer nrCamera;
    private Integer pretCamera;
    private Boolean ocupat;

    public Camera(String denumireCladire, Boolean nrClient, Integer nrCamera, Integer pretCamera, String tipCamera) {
        this.denumireCladire = denumireCladire;
        this.ocupat = nrClient;
        this.nrCamera = nrCamera;
        this.pretCamera = pretCamera;
        this.tipCamera = tipCamera;
    }

    protected Camera(Parcel in) {
        denumireCladire = in.readString();
        tipCamera = in.readString();
        if (in.readByte() == 0) {
            nrCamera = null;
        } else {
            nrCamera = in.readInt();
        }
        if (in.readByte() == 0) {
            pretCamera = null;
        } else {
            pretCamera = in.readInt();
        }
        byte tmpOcupat = in.readByte();
        ocupat = tmpOcupat == 0 ? null : tmpOcupat == 1;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(denumireCladire);
        dest.writeString(tipCamera);
        if (nrCamera == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(nrCamera);
        }
        if (pretCamera == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(pretCamera);
        }
        dest.writeByte((byte) (ocupat == null ? 0 : ocupat ? 1 : 2));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Camera> CREATOR = new Creator<Camera>() {
        @Override
        public Camera createFromParcel(Parcel in) {
            return new Camera(in);
        }

        @Override
        public Camera[] newArray(int size) {
            return new Camera[size];
        }
    };

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Camera{");
        sb.append("denumireCladire='").append(denumireCladire).append('\'');
        sb.append(", tipCamera='").append(tipCamera).append('\'');
        sb.append(", nrCamera=").append(nrCamera);
        sb.append(", pretCamera=").append(pretCamera);
        sb.append(", nrClient=").append(ocupat);
        sb.append('}');
        return sb.toString();
    }

    public String getDenumireCladire() {
        return denumireCladire;
    }

    public void setDenumireCladire(String denumireCladire) {
        this.denumireCladire = denumireCladire;
    }

    public Boolean getOcupat() {
        return ocupat;
    }

    public void setOcupat(Boolean ocupat) {
        this.ocupat = ocupat;
    }

    public Integer getNrCamera() {
        return nrCamera;
    }

    public void setNrCamera(Integer nrCamera) {
        this.nrCamera = nrCamera;
    }

    public Integer getPretCamera() {
        return pretCamera;
    }

    public void setPretCamera(Integer pretCamera) {
        this.pretCamera = pretCamera;
    }

    public String getTipCamera() {
        return tipCamera;
    }

    public void setTipCamera(String tipCamera) {
        this.tipCamera = tipCamera;
    }
}
