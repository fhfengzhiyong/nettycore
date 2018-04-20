package com.straw.spring.model;

import com.sun.xml.internal.rngom.binary.DataExceptPattern;

import java.util.Date;

/**
 * @author fengzy
 * @date 4/19/2018
 */
public class Order {
    private String orderId;
    private String userId;
    private Double price;
    private Date createDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
