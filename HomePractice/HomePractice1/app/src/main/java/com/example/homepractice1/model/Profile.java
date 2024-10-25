package com.example.homepractice1.model;

public class Profile {
    private String nume;
    private Integer varsta;
    private String gen;
    private Boolean sportiv;

    public Profile(String nume, Integer varsta, String gen, Boolean sportiv) {
        this.nume = nume;
        this.varsta = varsta;
        this.gen = gen;
        this.sportiv = sportiv;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "nume='" + nume + '\'' +
                ", varsta=" + varsta +
                ", gen='" + gen + '\'' +
                ", sportiv=" + sportiv +
                '}';
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Boolean getSportiv() {
        return sportiv;
    }

    public void setSportiv(Boolean sportiv) {
        this.sportiv = sportiv;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public Integer getVarsta() {
        return varsta;
    }

    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }
}
