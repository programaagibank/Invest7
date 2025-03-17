package com.invest7.view;

import com.invest7.controller.AuthController;
import com.invest7.controller.UserReadController;

import java.util.Scanner;

public class MenuPrincipal {
    public void ExibirMenuPrincipal() {
        clearTerminal();
        Scanner sc = new Scanner(System.in);

        String escolhas = "";

        while (!escolhas.equalsIgnoreCase("fim")) {
            System.out.println("1- Fazer Simulação Completa");
            System.out.println("2- Fazer Simulação por Perfil");
            System.out.println("3- FAQ");
            System.out.println("4- Visualizar seus dados cadastrais");
            System.out.println("5- Atualizar seus dados cadastrais");
            System.out.println("6- Logout");
            System.out.println("7- Deletar Conta");
            System.out.println("Digite 'fim' para sair!");
            escolhas = sc.next();

            switch (escolhas) {
                case "1":
                    MenuSimulacaoCompleta simulacaoCompleta = new MenuSimulacaoCompleta();
                    simulacaoCompleta.simulacaoCompleta();
                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":
                    UserReadController userRead = new UserReadController();
                    userRead.lerUser();

                    break;
                case "5":

                    break;
                case "6":
                    AuthController user = new AuthController();
                    user.logout();

                    break;
                case "7":
                    MenuDelete menuDelete = new MenuDelete();
                    menuDelete.confirmarDelete();
                    break;
                case "fim":

                    break;
                default:

                    break;
            }
        }

        sc.close();
    }

    private static void clearTerminal() {
        try {
            String operatingSystem = System.getProperty("os.name");
            if (operatingSystem.contains("Windows")) {
                // Comando para limpar no Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Comando para limpar no Linux/Mac
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
