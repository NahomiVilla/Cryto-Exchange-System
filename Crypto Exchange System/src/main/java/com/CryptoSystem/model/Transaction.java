package com.CryptoSystem.model;

import lombok.Data;

import java.util.Date;
import java.util.UUID;
@Data
public class Transaction {
    private UUID id=UUID.randomUUID();
    private  String type;
    private  Crypto crypto;
    private Double amount;
    private  Double price;
    private Date time;


    public Transaction( Double price, String type, Crypto crypto, Double amount) {

        this.price = price;
        this.type = type;
        this.crypto = crypto;
        this.amount = amount;
        this.time = new Date(System.currentTimeMillis());
    }
}
