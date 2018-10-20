package com.example.lucas.deliva.data.model.mock;

import java.io.Serializable;
import java.util.Date;

public class Purchase implements Serializable {

    private Integer purchaseId;
    private String date;
    private Integer status;
    private Double cost;

    public Purchase(Integer purchaseId, String date, Integer status, Double cost) {
        this.purchaseId = purchaseId;
        this.date = date;
        this.status = status;
        this.cost = cost;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
