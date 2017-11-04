package com.example.food.orderup;

import java.io.Serializable;
import java.util.HashMap;

public class final_order_model implements Serializable {

    HashMap<String, item_model_class> order;
    String userName;
    String phoneNo;

    final_order_model() {
    }

    public final_order_model(HashMap<String, item_model_class> order, String userName, String phoneNo) {
        this.order = order;
        this.userName = userName;
        this.phoneNo = phoneNo;
    }

    public HashMap<String, item_model_class> getOrder() {
        return order;
    }

    public void setOrder(HashMap<String, item_model_class> order) {
        this.order = order;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}