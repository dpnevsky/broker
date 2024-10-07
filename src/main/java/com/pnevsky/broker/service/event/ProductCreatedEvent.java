package com.pnevsky.broker.service.event;

import java.math.BigInteger;

public class ProductCreatedEvent {

    private String productId;
    private String title;
    private BigInteger price;
    private Integer quantity;

    public ProductCreatedEvent() {
    }

    public ProductCreatedEvent(String productId, Integer quantity, BigInteger price, String title) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.title = title;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
