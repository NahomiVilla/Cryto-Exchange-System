package com.CryptoSystem.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
@Data
public class Wallet {
    private Double balanceFiat;
    private Map<String,Double> cryptoBalance;


    public Wallet() {
        this.balanceFiat = 0.5;
        this.cryptoBalance = new HashMap<>();
    }

    public void depositFiat(Double amount){
        if (amount>0){
            this.balanceFiat+=amount;
        }
    }

    public  void buyCrypto(Crypto crypto,double amount){
        cryptoBalance.put(crypto.getSymbol(),cryptoBalance.getOrDefault(crypto.getSymbol(),0.0)+amount);
    }

    public  boolean sellCrypto(Crypto crypto,double amount){
        String symbol = crypto.getSymbol();
        if (cryptoBalance.containsKey(symbol) && cryptoBalance.get(symbol) >= amount) {
            cryptoBalance.put(symbol, cryptoBalance.get(symbol) - amount);
            return true;
        }
        return false;
    }

}
