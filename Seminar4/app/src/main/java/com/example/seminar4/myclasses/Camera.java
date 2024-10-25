package com.example.seminar4.myclasses;

public class Camera {
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
