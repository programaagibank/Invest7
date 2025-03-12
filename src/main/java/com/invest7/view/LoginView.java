package com.invest7.view;

import com.invest7.controller.AuthController;

import java.util.Scanner;

public class LoginView {
    public void exibirLogin(){
        String email;
        String senha;
        Scanner sc = new Scanner(System.in);

        System.out.println("Tela de Login!!!");
        System.out.println();
        System.out.println("Digite seu email ");
        email = sc.nextLine();
        System.out.println();
        System.out.println("Digite sua senha ");
        senha = sc.nextLine();

        AuthController authController = new AuthController();
        String resultado = authController.login(email,senha);

        System.out.println(resultado);
    }
}
