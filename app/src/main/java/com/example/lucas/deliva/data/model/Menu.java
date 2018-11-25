package com.example.lucas.deliva.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Menu implements Serializable {

    @SerializedName("id_service")
    private String id;

    private String name;

    private String description;

    @SerializedName("unit_value")
    private Double value;

    private String img;

    @SerializedName("qtde")
    private Integer amout;

    public Menu(String id, String name, String description, Double value, String img, Integer amout) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
        this.img = img;
        this.amout = amout;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getAmout() {
        return amout;
    }

    public void setAmout(Integer amout) {
        this.amout = amout;
    }
}
