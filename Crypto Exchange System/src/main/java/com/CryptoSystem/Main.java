package com.CryptoSystem;

import com.CryptoSystem.controller.UserController;
import com.CryptoSystem.model.Authentication;
import com.CryptoSystem.model.Users;
import com.CryptoSystem.vistas.AuthenticationView;
import com.CryptoSystem.vistas.MainMenuView;
import com.CryptoSystem.vistas.UserView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UserView userView=new UserView(scanner);
        Authentication authentication = new Authentication();
        AuthenticationView authenticationView=new AuthenticationView();
        UserController userController = new UserController(userView,authentication,authenticationView);

        MainMenuView mainMenuView=new MainMenuView(userController);
        mainMenuView.run();

    }
}