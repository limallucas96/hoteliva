package com.example.lucas.deliva.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CartReturn implements Serializable {

    @SerializedName("status")
    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
