package com.CryptoSystem.model;



public class SellOrder extends Order{
    public SellOrder(Users userId, Crypto cryptoSymbol, Double amount, Double price) {
        super(userId, cryptoSymbol, amount, price);
    }
    @Override
    public String toString() {
        return "SellOrder{" +
                "userId=" + getUserId().getId() +
                ", crypto=" + getCrypto().getName() +
                ", amount=" + getAmount() +
                ", price=" + getPrice() +
                '}';
    }
}
