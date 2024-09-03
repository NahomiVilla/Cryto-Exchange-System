package com.CryptoSystem.model;

import java.security.Timestamp;
import java.util.UUID;
import  lombok.Data;
@Data
public abstract class Order {
    private UUID id=UUID.randomUUID();
    private Users userId;
    private Crypto crypto;
    private Double amount;
    private  Double price;
    private Timestamp timestamp;

    public Order( Users userId, Crypto crypto, Double amount, Double price) {

        this.userId = userId;
        this.crypto = crypto;
        this.amount = amount;
        this.price = price;
    }


}
