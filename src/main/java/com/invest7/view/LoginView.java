package com.invest7.view;

import com.invest7.controller.AuthController;

import java.util.Scanner;

public class LoginView {
    public void exibirLogin(){
        String email;
        String senha;
        Scanner sc = new Scanner(System.in);
        MenuPrincipal menuPrincipal = new MenuPrincipal();

        System.out.println("Tela de Login!!!");
        System.out.println();
        System.out.println("Digite seu email ");
        email = sc.nextLine();
        System.out.println();
        System.out.println("Digite sua senha ");
        senha = sc.nextLine();

        AuthController authController = new AuthController();
        String resultado = authController.login(email,senha);

        if (resultado== null){
            System.out.println("usuario nao encontrado");
        } else {
            System.out.println("Login Realizado!! ");
            menuPrincipal.ExibirMenuPrincipal();
        }

    }
}
