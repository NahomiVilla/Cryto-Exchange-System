package com.CryptoSystem.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@Data
public class Crypto {
    private UUID id=UUID.randomUUID();
    private  String name;
    private  String symbol;
    private  Double ActualPrice;
    private static final Map<String, Double> defaultCryptoPrices= new HashMap<>();


    private static final Map<String, Crypto> cryptoRegistry = new HashMap<>();

    public Crypto( String name, String symbol, Double actualPrice) {

        this.name = name;
        this.symbol = symbol;
        this.ActualPrice = actualPrice;
        cryptoRegistry.put(symbol.toUpperCase(),this);

        defaultCryptoPrices.put("BTC", 50000.0); // Precio de Bitcoin
        defaultCryptoPrices.put("ETH", 3000.0);  // Precio de Ethereum


    }

    public static Crypto foundBySymbol(String symbol) {
        Crypto crypto = cryptoRegistry.get(symbol.toUpperCase());
        if (crypto == null) {
            throw new IllegalArgumentException("Criptomoneda no reconocida: " + symbol);
        }
        return crypto;
    }

    public double getCryptoPrice(String symbol) {
        return defaultCryptoPrices.getOrDefault(symbol.toUpperCase(), 0.0);
    }
    public static Map<String, Crypto> getAllCryptos() {
        return cryptoRegistry;
    }


}
