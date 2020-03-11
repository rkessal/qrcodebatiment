package com.example.qrcodebatiment.models;

import com.tickaroo.tikxml.annotation.Attribute;
import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Path;
import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

import java.util.List;

@Xml
public class MXAsset {

    @Element(name = "MXASSETSet")
    Asset MXASSETSet;

    public MXAsset() {

    }

    public Asset getMXASSETSet() {
        return this.MXASSETSet;
    }
}