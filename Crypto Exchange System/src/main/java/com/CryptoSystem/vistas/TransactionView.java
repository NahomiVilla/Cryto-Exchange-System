package com.CryptoSystem.vistas;

import com.CryptoSystem.Interfaces.TransactionInterface;
import com.CryptoSystem.model.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TransactionView implements TransactionInterface {
    private final Scanner scanner=new Scanner(System.in);

    public PurchaseOrder requestPurchase(Users users){
        System.out.println("Ingrese la criptomoneda (BTC,ETH,etc.): ");
        String cryptoname=scanner.nextLine();
        Crypto crypto=Crypto.foundBySymbol(cryptoname.toUpperCase());

        System.out.println("Ingrese la cantiddad que desea comprar: ");
        double cantidad=scanner.nextDouble();

        System.out.println("Ingrese el precio maximo a pagar: ");
        double price=scanner.nextDouble();

        return new PurchaseOrder(users,crypto,cantidad,price);
    }

    public SellOrder requestSale(Users users) {
        System.out.print("Ingrese la criptomoneda (BTC, ETH, etc.): ");
        String cryptoname = scanner.nextLine();
        Crypto crypto = Crypto.foundBySymbol(cryptoname.toUpperCase());
        Wallet wallet = users.getWallet();
        if (!wallet.getCryptoBalance().containsKey(crypto.getSymbol())) {
            System.out.println("Error: No tienes esta criptomoneda en tu cartera.");
            return null;
        }
        System.out.print("Ingrese la cantidad a vender: ");
        double cantidad = scanner.nextDouble();
        if (wallet.getCryptoBalance().get(crypto.getSymbol()) < cantidad) {
            System.out.println("Error: No tienes suficiente " + crypto.getName() + " para vender.");
            return null;
        }
        System.out.print("Ingrese el precio: ");
        double precio = scanner.nextDouble();

        return new SellOrder(users, crypto, cantidad, precio);
    }
    public Crypto buyCrypto(){

        Map<String,Crypto>cryptos=Crypto.getAllCryptos();
        for (Crypto crypto:cryptos.values()){
            System.out.println(crypto.getSymbol()+" - "+crypto.getName()+" - "+crypto.getActualPrice());
        }
        System.out.println("Ingrese la cryptomoneda a comprar (BTC,ETH): ");
        String cryptoSymbol=scanner.nextLine();
        Crypto crypto=Crypto.foundBySymbol(cryptoSymbol);
        return crypto;

    }

    public double solicitarCantidad(){
        System.out.println("Ingrese la cantidad : ");
        return scanner.nextDouble();
    }

    public  void showHistoryTransaction(List<Transaction> history){
        if (history.isEmpty()){
            System.out.println("Historial vacío");

        }else {
            for (Transaction transaction:history){
                System.out.println("ID: "+transaction.getId());
                System.out.println("TYPE: "+transaction.getType());
                System.out.println("CRYPTO: "+transaction.getCrypto());
                System.out.println("AMOUNT: "+transaction.getAmount());
                System.out.println("PRICE: "+transaction.getPrice());
                System.out.println("DATE: "+transaction.getTime());

            }
        }
    }
    public void showBalance(double balanceFiat, Map<String, Double> cryptoHoldings) {
        System.out.println("Saldo en dinero: $" + balanceFiat);
        System.out.println("Saldo en criptomonedas:");
        for (Map.Entry<String, Double> entry : cryptoHoldings.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
