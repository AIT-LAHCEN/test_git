package com.example.tp3;


public class Etablissement {

    private String label;
    private String name;
    private int imag;
    private double lon;
    private double lat;

    //Le constructeur
    public Etablissement(String label, String name, int img, double lon, double lat){
        this.label= label;
        this.name= name;
        this.imag=img;
        this.lon=lon;
        this.lat=lat;
    }

    public double getLon() { return lon; }

    public double getLat() { return lat; }

    public String getLabel() {
        return label;
    }

    public int getImage() {
        return imag;
    }

    public String getName() {
        return name;
    }
}
