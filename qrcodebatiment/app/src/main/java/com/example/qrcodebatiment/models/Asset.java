package com.example.qrcodebatiment.models;

import com.tickaroo.tikxml.TypeConverter;
import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

@Xml
public class Asset{
    @Element(name = "ASSET")
    Batiment batiment;

    public Batiment getBatiment() {
        return this.batiment;
    }
}
