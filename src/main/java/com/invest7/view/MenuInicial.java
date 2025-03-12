package com.invest7.view;

import java.util.Scanner;

public class MenuInicial {

    public void exibirMenuInicial(){
        Scanner sc = new Scanner(System.in);

        String escolhas = "";

        while (!escolhas.equalsIgnoreCase("fim")) {
            System.out.println("1- Fazer login");
            System.out.println("2- Fazer Cadastro");
            System.out.println("3- Fazer Prévia de Simulação");
            System.out.println("4- Fazer Prévia de questionário");
            System.out.println("Digite 'fim' para sair");
            escolhas = sc.next();

            switch (escolhas) {
                case "1":
                    LoginView loginView = new LoginView();
                    loginView.exibirLogin();
                    break;
                case "2":
                    CadastroView cadastroView = new CadastroView();
                    System.out.println("Cadastro selecionado");
                    break;
                case "3":
                    // Código para fazer prévia de simulação
                    System.out.println("Prévia de simulação selecionada");
                    break;
                case "4":
                    // Código para fazer prévia de questionário
                    System.out.println("Prévia de questionário selecionada");
                    break;
                case "fim":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        sc.close();

    }
}
