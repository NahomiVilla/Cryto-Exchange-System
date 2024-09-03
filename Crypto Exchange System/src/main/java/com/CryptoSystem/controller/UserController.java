package com.CryptoSystem.controller;

import com.CryptoSystem.Interfaces.UserInterface;
import com.CryptoSystem.model.Authentication;
import com.CryptoSystem.model.Crypto;
import com.CryptoSystem.model.Users;
import com.CryptoSystem.model.Wallet;
import com.CryptoSystem.vistas.AuthenticationView;

import java.util.List;

public class UserController {
    private final UserInterface userInterface;
    private AuthenticationView authenticationView;
    private Authentication authentication;
    public UserController(UserInterface userInterface, Authentication authentication, AuthenticationView authenticationView) {
        this.userInterface = userInterface;
        this.authentication=authentication;
        this.authenticationView=authenticationView;
    }

    public Users createUser(){
        List<String> datos=userInterface.solicitarDatos();
        Users newUser=new Users(datos.get(0),datos.get(1),datos.get(2));
        authentication.registerUser(datos.get(1),newUser);
        Wallet wallet = newUser.getWallet();
        wallet.buyCrypto(new Crypto("Bitcoin", "BTC", 0.0), 1.0); // 1 BTC inicial
        wallet.buyCrypto(new Crypto("Ethereum", "ETH", 0.0), 5.0); // 5 ETH iniciales

        System.out.println("Usuario creado con exito");
        return newUser;

    }

    public Users login(){
        List<String> datosLogin=authenticationView.datosLogin();

        if (authentication.login(datosLogin.get(0), datosLogin.get(1))) {

            System.out.println("inicio de sesion exitoso...");
            return authentication.getUser();
        }else {
            System.out.println("Credenciales incorrectas...");
            return null;
        }
    }

    public void singOut(){
        if (authentication.isSesionIniciada()){
            authentication.singOut();
            System.out.println("Sesión cerrada...");
        }else{
            System.out.println("No hay sesión iniciada");
        }
    }

}
