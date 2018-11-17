package com.example.lucas.deliva.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {

    @SerializedName("user")
    private String user;

    @SerializedName("name")
    private String name;

    @SerializedName("is_authenticated")
    private Integer isAuthenticaded;

    @SerializedName("room_id")
    private Integer roomId;

    @SerializedName("room_number")
    private Integer roomNumber;

    @SerializedName("room_daily_value")
    private Double roomValue;

    @SerializedName("room_description")
    private String roomDescription;

    @SerializedName("user_id")
    private Integer userId;

    @SerializedName("room_floor")
    private Integer roomFloor;

    private Boolean isLogged = false;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsAuthenticaded() {
        return isAuthenticaded;
    }

    public void setIsAuthenticaded(Integer isAuthenticaded) {
        this.isAuthenticaded = isAuthenticaded;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer room_number) {
        this.roomNumber = room_number;
    }

    public Double getRoomValue() {
        return roomValue;
    }

    public void setRoomValue(Double roomValue) {
        this.roomValue = roomValue;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public Integer getRoomFloor() {
        return roomFloor;
    }

    public void setRoomFloor(Integer roomFloor) {
        this.roomFloor = roomFloor;
    }

    public Boolean getLogged() {
        return isLogged;
    }

    public void setLogged(Boolean logged) {
        isLogged = logged;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}

