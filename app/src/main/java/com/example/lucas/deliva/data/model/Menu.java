package com.example.lucas.deliva.data.model;

import java.io.Serializable;

public class Menu implements Serializable {

    private String id;

    private String name;

    private String description;

    private Double value;

    private String img;

    public Menu(String id, String name, String description, Double value, String img) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
        this.img = img;
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
}
