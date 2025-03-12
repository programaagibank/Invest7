package com.invest7.view;

import java.util.Scanner;

public class MenuPrincipal {
    public void ExibirMenuPrincipal() {
        Scanner sc = new Scanner(System.in);

        String escolhas = "";

        while (!escolhas.equalsIgnoreCase("fim")) {
            System.out.println("1- Fazer Simulação Completa");
            System.out.println("2- Fazer Simulação por Perfil");
            System.out.println("3- FAQ");
            System.out.println("4- Atualizar dados cadastrais");
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


                    break;
                case "fim":

                    break;
                default:

                    break;
            }
        }

        sc.close();
    }
}
