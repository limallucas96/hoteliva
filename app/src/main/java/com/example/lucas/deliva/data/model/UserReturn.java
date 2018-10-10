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

    @SerializedName("user_id")
    private String userId;

    @SerializedName("room_id")
    private String roomId;

    private Boolean isLogged = false;

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

    public Boolean getLogged() {
        return isLogged;
    }

    public void setLogged(Boolean logged) {
        isLogged = logged;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}

