package com.example.qrcodebatiment.models;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

import java.util.List;

@Xml(name = "ASSET")
public class Batiment {
    @PropertyElement
    String ASSETNUM;

    @PropertyElement
    String DESCRIPTION;

    @Element
    List<PieceJointe> DOCLINKS;

    public Batiment() {

    }

    public String getASSETNUM() {
        return ASSETNUM;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public List<PieceJointe> getDOCLINKS() {
        return DOCLINKS;
    }
}
