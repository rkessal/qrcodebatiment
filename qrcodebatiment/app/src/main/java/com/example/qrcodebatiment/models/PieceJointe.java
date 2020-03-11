package com.example.qrcodebatiment.models;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

@Xml
class PieceJointe {
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
}
