package com.example.startandroid;

/**
 * Created by Владелец on 01.06.2018.
 */

public class Product {

    String name;
    int price;
    int image;
    boolean box;


    Product(String _describe, int _price, int _image, boolean _box) {
        name = _describe;
        price = _price;
        image = _image;
        box = _box;
    }
}