package com.CryptoSystem.vistas;

import com.CryptoSystem.Interfaces.AuthenticationInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuthenticationView implements AuthenticationInterface {
    private Scanner scanner=new Scanner(System.in);

    public List<String> datosLogin(){
        ArrayList<String> datos = new ArrayList<>();
        System.out.println("Ingrese su email registrado:");
        datos.add(scanner.nextLine());
        System.out.println("Ingrese su contraseña:");
        datos.add(scanner.nextLine());
        return datos;

    }
}
