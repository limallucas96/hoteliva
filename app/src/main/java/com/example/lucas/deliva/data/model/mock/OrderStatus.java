package com.example.lucas.deliva.data.model.mock;

import java.io.Serializable;
import java.util.List;

public class OrderStatus implements Serializable {

    private Integer orderId;
    private List<Menu> orderList;
    private String image;
    private Integer currentStatus;
    private String roomNumber;

    public OrderStatus(Integer orderId, List<Menu> orderList, String image, Integer currentStatus, String roomNumber) {
        this.orderId = orderId;
        this.orderList = orderList;
        this.image = image;
        this.currentStatus = currentStatus;
        this.roomNumber = roomNumber;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public List<Menu> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Menu> orderList) {
        this.orderList = orderList;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Integer currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
