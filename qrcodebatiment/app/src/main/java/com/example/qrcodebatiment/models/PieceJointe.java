package com.example.qrcodebatiment.models;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name = "DOCLINKS")
public class PieceJointe {
    @PropertyElement
    String DESCRIPTION;

    @PropertyElement
    String DOCTYPE;

    @PropertyElement
    String WEBURL;

    public PieceJointe() {

    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public String getDOCTYPE() {
        return DOCTYPE;
    }

    public String getWEBURL() {
        return WEBURL;
    }

    public String getNameUrl() {
        String[] url = this.getWEBURL().split("/");
        return url[url.length - 1];
    }
}
