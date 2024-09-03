package com.CryptoSystem.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Data
public class Users {
    private UUID Id =UUID.randomUUID();
    private String name;
    private  String email;
    private String password;
    private  Wallet wallet;
    private List<Transaction> transactionHistory = new ArrayList<>();  // Lista de transacciones


    public Users( String name, String email, String password){

        this.name = name;
        this.email = email;
        this.password = password;
        this.wallet = new Wallet();
    }

    public Users() {

    }


    public  void addTransaction(Transaction transaction){
        transactionHistory.add(transaction);
    }

}
