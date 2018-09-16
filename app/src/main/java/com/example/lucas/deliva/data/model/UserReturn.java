package com.example.lucas.deliva.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserReturn implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("user")
    private String user;

    @SerializedName("adm")
    private Boolean isAdm;

    @SerializedName("is_authenticated")
    private Integer isAuthenticaded;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Boolean getAdm() {
        return isAdm;
    }

    public void setAdm(Boolean adm) {
        isAdm = adm;
    }

    public Integer getIsAuthenticaded() {
        return isAuthenticaded;
    }

    public void setIsAuthenticaded(Integer isAuthenticaded) {
        this.isAuthenticaded = isAuthenticaded;
    }
}

