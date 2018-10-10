package com.example.lucas.deliva.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {

    @SerializedName("user")
    private String user;

    @SerializedName("pwd")
    private String password;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("room_id")
    private String roomId;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
