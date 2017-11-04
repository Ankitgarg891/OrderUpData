package com.example.food.orderup;

import java.io.Serializable;

class item_model_class implements Serializable {

    private String name;
    private String price;
    private int image;
    private int quantity;

    public item_model_class() {
    }

    public item_model_class(String name, String price, int image) {

        this.name = name;
        this.price = price;
        this.image = image;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

}