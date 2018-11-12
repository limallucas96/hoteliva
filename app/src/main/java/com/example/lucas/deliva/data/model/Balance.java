package com.example.lucas.deliva.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Balance implements Serializable {

    @SerializedName("id_resident")
    private Integer residentId;


    public class BalanceMenu implements Serializable{

        @SerializedName("name")
        private String name;

        @SerializedName("description")
        private String description;

        @SerializedName("value")
        private Double value;

        @SerializedName("date")
        private String date;

        @SerializedName("status")
        private Integer status;

        @SerializedName("amount")
        private Integer amount;

        @SerializedName("Id_service")
        private Integer serviceId;

        @SerializedName("item.id_order")
        private Integer orderId;

        @SerializedName("total_value")
        private Double totalValue;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Double getValue() {
            return value;
        }

        public void setValue(Double value) {
            this.value = value;
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

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

        public Integer getServiceId() {
            return serviceId;
        }

        public void setServiceId(Integer serviceId) {
            this.serviceId = serviceId;
        }
    }

}
