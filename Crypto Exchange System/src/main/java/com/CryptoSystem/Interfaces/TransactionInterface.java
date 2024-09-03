package com.CryptoSystem.Interfaces;

import com.CryptoSystem.model.*;

import java.util.List;
import java.util.Map;

public interface TransactionInterface {
    PurchaseOrder requestPurchase(Users users);
    SellOrder requestSale(Users users);
    void showBalance(double balanceFiat, Map<String, Double> cryptoHoldings);

    Crypto buyCrypto();

    void showHistoryTransaction(List<Transaction> transactionHistory);

    double solicitarCantidad();
}
