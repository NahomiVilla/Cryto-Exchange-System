package com.CryptoSystem.model;


public class PurchaseOrder extends Order{
    public PurchaseOrder(Users userId, Crypto cryptoSympol, Double amount, Double price) {
        super( userId, cryptoSympol, amount, price);
    }
    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "userId=" + getUserId().getId() +
                ", crypto=" + getCrypto().getName() +
                ", amount=" + getAmount() +
                ", price=" + getPrice() +
                '}';
    }

}
