package com.CryptoSystem.vistas;

import com.CryptoSystem.Interfaces.UserInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserView implements UserInterface {
    private Scanner scanner;

    public UserView(Scanner scanner) {
        this.scanner =new Scanner(System.in);
    }
    public  List<String> solicitarDatos(){
        ArrayList<String> datos = new ArrayList<>();
        System.out.println("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        datos.add(nombre);
        System.out.println("Ingrese su email: ");
        String email=scanner.nextLine();
        datos.add(email);
        System.out.println("Ingrese su contraseña: ");
        String password= scanner.nextLine();
        datos.add(password);
        visualizarDatosIngresados(datos);
        return datos;
    }
    public  void visualizarDatosIngresados(ArrayList<String> datos){
        System.out.println("Datos Ingresados: ");
        for (String dato:datos){
            System.out.println(dato);
        }
    }




    
    
}
