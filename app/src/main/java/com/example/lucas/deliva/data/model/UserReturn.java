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
    private Integer roomId;

    @SerializedName("room_number")
    private Integer room_number;

    @SerializedName("room")
    private String room;

    @SerializedName("profile_picture")
    private String profilePicture;

    @SerializedName("room_daily_value")
    private Double roomValue;

    @SerializedName("room_description")
    private String roomDescription;

    @SerializedName("room_floor")
    private Integer roomFloor;

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

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getRoom_number() {
        return room_number;
    }

    public void setRoom_number(Integer room_number) {
        this.room_number = room_number;
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
}

