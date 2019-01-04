package com.example.alaba.retrofittest.models;

import android.graphics.drawable.BitmapDrawable;

public class Room {
    private int id;
    private int adult;
    private int child;
    public String type;
    private String photo;
    private String description;
    private int available;
    private float price;

    private BitmapDrawable bmphoto;

    public Room(int id, int adult, int child, String type, String photo, String description, int available, float price) {
        this.id = id;
        this.adult = adult;
        this.child = child;
        this.type = type;
        this.photo = photo;
        this.description = description;
        this.available = available;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getAdult() {
        return adult;
    }

    public int getChild() {
        return child;
    }

    public String getType() {
        return type;
    }

    public String getPhoto() {
        return photo;
    }

    public String getDescription() {
        return description;
    }

    public int getAvailable() {
        return available;
    }

    public float getPrice() {
        return price;
    }

    public BitmapDrawable getBmphoto() {
        return bmphoto;
    }

    public void setBmphoto(BitmapDrawable bmphoto) {
        this.bmphoto = bmphoto;
    }
}
