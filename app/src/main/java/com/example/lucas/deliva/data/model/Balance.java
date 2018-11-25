package com.example.lucas.deliva.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Balance implements Serializable {

    private String orderId;

    @SerializedName("date")
    private String date;

    @SerializedName("description")
    private String description;

    @SerializedName("id_service")
    private Integer idService;

    @SerializedName("name")
    private String name;

    @SerializedName("qtde")
    private Integer amount;

    @SerializedName("status")
    private String status;

    @SerializedName("total_value")
    private Double totalValue;

    @SerializedName("value")
    private Double value;

    private Integer roomNumber;

    public Balance(String orderId, String date, String description, Integer idService, String name, Integer amount, String status, Double totalValue, Double value) {
        this.orderId = orderId;
        this.date = date;
        this.description = description;
        this.idService = idService;
        this.name = name;
        this.amount = amount;
        this.status = status;
        this.totalValue = totalValue;
        this.value = value;
    }

    public Balance(String orderId, String date, String description, Integer idService, String name, Integer amount, String status, Double totalValue, Double value, Integer roomNumber) {
        this.orderId = orderId;
        this.date = date;
        this.description = description;
        this.idService = idService;
        this.name = name;
        this.amount = amount;
        this.status = status;
        this.totalValue = totalValue;
        this.value = value;
        this.roomNumber = roomNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
}
