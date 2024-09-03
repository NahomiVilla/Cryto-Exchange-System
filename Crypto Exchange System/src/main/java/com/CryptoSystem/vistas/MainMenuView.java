package com.CryptoSystem.vistas;

import com.CryptoSystem.Interfaces.TransactionInterface;
import com.CryptoSystem.controller.TransactionController;
import com.CryptoSystem.controller.UserController;
import com.CryptoSystem.exceptions.Exceptions;
import com.CryptoSystem.model.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenuView {
    Boolean running=true;
    private UserController userController ;
    private Scanner scanner;

    public  MainMenuView(UserController userController ) {
        this.userController = userController;
        this.scanner = new Scanner(System.in);
    }

    private static void MenuTransaccional(Users users, TransactionInterface transactionInterface, Scanner scanner, UserController userController){
        TransactionController transactionController=new TransactionController(transactionInterface,users);

        while (true){
            try{
                System.out.printf("%"+30+ "s%n","TRANSACTIONAL MENU");
                System.out.println("1. Realizar orden de compra");
                System.out.println("2. Realizar orden de venta");
                System.out.println("3. Realizar compra de crypto");
                System.out.println("4. Ver historial de transacciones");
                System.out.println("5. Deposito");
                System.out.println("6. Ver balance");
                System.out.println("7. Cerrar Sesion");
                System.out.println("Select an option: ");
                int option= scanner.nextInt();
                switch (option){
                    case 1:
                        PurchaseOrder purchaseOrder=transactionInterface.requestPurchase(users);
                        transactionController.madePurchase(purchaseOrder);
                        break;
                    case 2:
                        SellOrder sellOrder=transactionInterface.requestSale(users);
                        transactionController.madeSale(sellOrder);
                        break;
                    case 3:
                        Crypto selectedcrypto=transactionInterface.buyCrypto();
                        transactionController.BuyCrypto(selectedcrypto);
                    case 4:
                        transactionController.showHoistoryTransaction();
                        break;
                    case 5:
                        transactionController.deposit();
                        break;
                    case 6:
                        transactionController.showBalance();
                        break;
                    case 7:
                        userController.singOut();
                        System.out.println("Sesion cerrada");
                        return;
                    default:
                        throw new Exceptions.OptionNotFoundException("La opcion seleccionada no existe, por favor ingrese una opcion valida");

                    }
                }catch (InputMismatchException e){
                    throw new Exceptions.OptionNotMatchException("ENTRADA NO VALIDA");
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }
        }

    public void  run(){
        while (running){
            try{
                System.out.printf("%"+30+ "s%n","CRYPTO SYSTEM");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Quit");
                System.out.println("Select an option: ");
                int option= scanner.nextInt();

                switch (option){
                    case 1:
                        userController.createUser();
                        break;
                    case 2:
                        Users user= userController.login();
                        if (user!=null){
                        MenuTransaccional(user,new TransactionView(),scanner,userController);}
                        break;
                    case 3:
                        running=false;
                        break;
                    default:
                        throw new Exceptions.OptionNotFoundException("La opcion seleccionada no existe, por favor ingrese una opcion valida");
                }
            }catch (InputMismatchException e){
                throw new Exceptions.OptionNotMatchException("ENTRADA NO VALIDA");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
    }



