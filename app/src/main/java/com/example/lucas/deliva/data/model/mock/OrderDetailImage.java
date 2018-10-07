package com.example.lucas.deliva.data.model.mock;

import java.io.Serializable;

public class OrderDetailImage implements Serializable {

    private String image;

    public OrderDetailImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
