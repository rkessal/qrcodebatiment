package com.example.qrcodebatiment.models;

import com.tickaroo.tikxml.annotation.Xml;

@Xml
public class Batiment {

    private String numBatiment;

    public Batiment() {

    }

    public Batiment(String numBatiment) {
        this.numBatiment = numBatiment;
    }

    public String getNumBatiment() {
        return numBatiment;
    }

    public void setNumBatiment(String numBatiment) {
        this.numBatiment = numBatiment;
    }
}
