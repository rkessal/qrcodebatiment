package com.example.qrcodebatiment.test;
import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Xml;

import java.util.List;

//A changer en batiment

@Xml
public class Breakfast {
    @Element
    List<Food> foodList;

    public Breakfast() {

    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}

