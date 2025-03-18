package com.invest7.view;

import com.invest7.controller.UserController;
import com.invest7.model.UserModel;

import java.util.Scanner;

public class MenuPrincipal {
    public void ExibirMenuPrincipal() {
        Scanner sc = new Scanner(System.in);

        String escolhas = "";

        while (!escolhas.equalsIgnoreCase("fim")) {
            System.out.println("1- Fazer Simulação Completa");
            System.out.println("2- Fazer Simulação por Perfil");
            System.out.println("3- FAQ");
            System.out.println("4- Visualizar seus dados cadastrados");
            System.out.println("5- Atualizar seus dados cadastrais");
            System.out.println("6- Refazer Questionário");
            System.out.println("7- Logout");
            System.out.println("8- Deletar Conta");
            System.out.println("Digite 'fim' para sair!");
            escolhas = sc.next();

            switch (escolhas) {
                case "1":
                    MenuSimulacaoCompleta simulacaoCompleta = new MenuSimulacaoCompleta();
                    simulacaoCompleta.simulacaoCompleta();
                    break;
                case "2":
                    //
                    break;
                case "3":
                        // fazer FAQ
                    break;
                case "4":
                    UserController userC = new UserController();
                    UserModel userR = userC.lerUser();
                    if (userR != null) {
                        System.out.println("Usuário encontrado:");
                        System.out.println("Nome: " + userR.getNome());
                        System.out.println("Email: " + userR.getEmail());
                        System.out.println("CPF: " + userR.getCpf());
                        System.out.println("Gênero: " + userR.getGenero());
                        System.out.println("Endereço: " + userR.getEndereco());
                        System.out.println("Data de Nascimento: " + userR.getDt_nasc());
                    }  else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;

                case "5":
                    MenuUptade menuUptade = new MenuUptade();
                    menuUptade.MenuUptade();
                    break;
                case "6":


                    break;
                case "7":
                   // AuthController user = new AuthController();
                    UserController user = new UserController();
                    user.logout();

                    break;
                case "8":
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

}
