package com.CryptoSystem.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderBook {
    private List<PurchaseOrder> ordenesCompra;
    private List<SellOrder> ordenesVenta;
    private static OrderBook instance;
    public OrderBook() {
        this.ordenesCompra = new ArrayList<>();
        this.ordenesVenta = new ArrayList<>();
    }

    public static synchronized OrderBook getInstance() {
        if (instance == null) {
            instance = new OrderBook();
        }
        return instance;
    }



}
