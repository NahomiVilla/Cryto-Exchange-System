package com.CryptoSystem.controller;

import com.CryptoSystem.Interfaces.TransactionInterface;
import com.CryptoSystem.exceptions.Exceptions;
import com.CryptoSystem.model.*;


public class TransactionController {
    private TransactionInterface transactionInterface;
    private Users users;
    OrderBookController orderBookController;
    OrderBook orderBook;
    public TransactionController(TransactionInterface transactionInterface, Users users) {
        this.transactionInterface = transactionInterface;
        this.users = users;
        this.orderBook=new OrderBook();
        this.orderBookController=new OrderBookController();
    }

    public void madePurchase(PurchaseOrder order){
        double totalCost=order.getAmount()*order.getPrice();
        Wallet wallet=users.getWallet();

        if(wallet.getBalanceFiat()>=totalCost){
            System.out.println("ordercontroller...");
            orderBookController.addPurchaseorder(order);

            System.out.println("Compra realizada con exito");
        }else{
            throw new Exceptions.FondosInsuficientesException("Fondos  insuficientes para realizar la transacción deseada");
        }
    }

    public  void madeSale(SellOrder order){

        if (order==null){
            System.out.println("venta cancelada");
            return;
        }
        Wallet wallet=users.getWallet();
        if (wallet.sellCrypto(order.getCrypto(),order.getAmount())){
            orderBookController.addSellOrder(order);

            System.out.println("Orden de venta agregada al libro de órdenes. Esperando coincidencia...");
        }else {
            throw new  Exceptions.FondosInsuficientesException("Saldo insuficiente para realiza la transacción deseada");
        }
    }

    public void BuyCrypto(Crypto crypto){
        Wallet wallet=users.getWallet();
        double amount=transactionInterface.solicitarCantidad();
        double costPerUnit=crypto.getCryptoPrice(crypto.getSymbol());
        double costoTotal= costPerUnit*amount;


        if (wallet.getBalanceFiat()>=costoTotal){
            wallet.depositFiat(-costoTotal);
            wallet.buyCrypto(crypto,amount);
            Transaction transaction = new Transaction(costoTotal, "compra directa", crypto, amount);
            users.addTransaction(transaction);
            System.out.println("Compra de "+amount+" "+crypto.getName()+" realizada con exito");
        }else {
            throw new Exceptions.FondosInsuficientesException("Fondos insuficientes para realizar la compra");
        }
    }

    public void deposit(){
        double cantidad=transactionInterface.solicitarCantidad();
        if (users!=null){
            users.getWallet().depositFiat(cantidad);
            Transaction transaction=new Transaction(0.0,"deposito",null,cantidad);
            users.addTransaction(transaction);
            System.out.println("Depósito exitoso. Su nuevo balance es: $"+users.getWallet().getBalanceFiat());
        }else {
            throw new  Exceptions.UserNotFoundException("Error:Usuario no registrado");
        }
    }

    public void showBalance() {
        if (users == null) {
            throw new Exceptions.UserNotFoundException("Error: Usuario no registrado.");
        }
        Wallet wallet = users.getWallet();
        transactionInterface.showBalance(wallet.getBalanceFiat(), wallet.getCryptoBalance());
    }

    public void showHoistoryTransaction(){
        transactionInterface.showHistoryTransaction(users.getTransactionHistory());
    }
}
