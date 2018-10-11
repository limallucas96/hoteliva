package com.example.lucas.deliva.data.model.mock;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {

    private Integer userId;
    private Integer roomId;
    private List<Menu> menuList;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
}
