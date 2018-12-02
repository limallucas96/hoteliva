package com.example.lucas.deliva.data.model;

import java.io.Serializable;
import java.util.List;

public class OrderDetailImage implements Serializable {

    private String id;
    private List<String> image;
    private String rating;
    private String suits;
    private String averageTime;

    public OrderDetailImage(String id, List<String> image, String rating, String suits, String averageTime) {
        this.id = id;
        this.image = image;
        this.rating = rating;
        this.suits = suits;
        this.averageTime = averageTime;
    }

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSuits() {
        return suits;
    }

    public void setSuits(String suits) {
        this.suits = suits;
    }

    public String getAvarageTime() {
        return averageTime;
    }

    public void setAvarageTime(String avarageTime) {
        this.averageTime = avarageTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
