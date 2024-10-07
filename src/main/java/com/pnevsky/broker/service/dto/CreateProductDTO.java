package com.pnevsky.broker.service.dto;

import java.math.BigInteger;

public class CreateProductDTO {

    private String title;
    private BigInteger price;
    private Integer quantity;

    public CreateProductDTO() {
    }

    public CreateProductDTO(String title, Integer quantity, BigInteger price) {
        this.title = title;
        this.quantity = quantity;
        this.price = price;
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
