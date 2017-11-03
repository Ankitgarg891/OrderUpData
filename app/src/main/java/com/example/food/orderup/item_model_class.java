package com.example.food.orderup;

import java.io.Serializable;

/**
 * Created by Dipanshu on 02-11-2017.
 */

class item_model_class implements Serializable {

    private String name;
    private String price;
    private int image;
    private int quantity;

    private String UserName;
    private String PhoneNo;

    public item_model_class(String name,String price,int image,String userName,String phoneNo)
    {

        this.name = name;
        this.price = price;
        this.image = image;
        this.UserName = userName;
        this.PhoneNo = phoneNo;
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

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }
}


