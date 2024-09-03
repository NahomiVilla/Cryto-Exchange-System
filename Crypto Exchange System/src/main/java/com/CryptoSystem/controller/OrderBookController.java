package com.CryptoSystem.controller;

import com.CryptoSystem.model.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;

public class OrderBookController {
    private OrderBook orderBook;

    public OrderBookController() {
        this.orderBook = OrderBook.getInstance();
    }
    public void saveOrderBookToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Guardar órdenes de compra
            for (PurchaseOrder purchase : orderBook.getOrdenesCompra()) {
                writer.write("Compra: " + purchase.toString());
                writer.newLine();
            }
            // Guardar órdenes de venta
            for (SellOrder sell : orderBook.getOrdenesVenta()) {
                writer.write("Venta: " + sell.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar el OrderBook: " + e.getMessage());
        }
    }


    public void addPurchaseorder(PurchaseOrder purchaseCompra){
        orderBook.getOrdenesCompra().add(purchaseCompra);
        System.out.println("enviando a coincidencia");
        coincidence();

    }

    public void addSellOrder(SellOrder sellOrder){
        orderBook.getOrdenesVenta().add(sellOrder);
        coincidence();
    }

    //verificar coincidencia
    public void coincidence(){
        System.out.println("entrando a coincidencia...");
        List<PurchaseOrder> comprasCompletadas=new ArrayList<>();
        List<SellOrder>ventasCompletadas=new ArrayList<>();
        System.out.println("Número de órdenes de venta: " + orderBook.getOrdenesVenta().size());
        System.out.println("Número de órdenes de compra: " + orderBook.getOrdenesCompra().size());

        for (PurchaseOrder purchase: orderBook.getOrdenesCompra()){
            System.out.println("primer for");
            for(SellOrder sell: orderBook.getOrdenesVenta()){
                System.out.println("segundo   for");
                if (purchase.getCrypto().getSymbol().equals(sell.getCrypto().getSymbol())&&

                        purchase.getAmount().equals(sell.getAmount()) &&
                        purchase.getPrice()>=sell.getPrice()){
                        System.out.println("enviando a ejecucion");
                        exeTransactions(purchase,sell);
                        comprasCompletadas.add(purchase);
                        ventasCompletadas.add(sell);
                }
            }
        }
        orderBook.getOrdenesCompra().removeAll(comprasCompletadas);
        orderBook.getOrdenesVenta().removeAll(ventasCompletadas);
        saveOrderBookToFile("order_book.txt");
    }

    private void exeTransactions(PurchaseOrder purchase, SellOrder sell) {
        double preciotransaccion= sell.getPrice();
        double cantidadtotal=sell.getAmount();
        double costo=preciotransaccion*cantidadtotal;
        System.out.println("ejecutando transaccion");
        Wallet buyerWallet=purchase.getUserId().getWallet();
        Wallet sellerWallet=sell.getUserId().getWallet();

        buyerWallet.depositFiat(-costo);
        buyerWallet.buyCrypto(purchase.getCrypto(),cantidadtotal);

        sellerWallet.depositFiat(costo);
        sellerWallet.sellCrypto(sell.getCrypto(),cantidadtotal);
        System.out.println("agregando transaccion");
        Transaction buyerTransaction =new Transaction(preciotransaccion,"compra",purchase.getCrypto(),cantidadtotal);
        Transaction sellerTransaction=new Transaction(preciotransaccion,"venta",sell.getCrypto(),cantidadtotal);
        purchase.getUserId().addTransaction(buyerTransaction);
        sell.getUserId().addTransaction(sellerTransaction);
        System.out.println("Transacción ejecutada: Compra de " + cantidadtotal + " de " +
                purchase.getCrypto().getName() + " a " + preciotransaccion);


    }


}
