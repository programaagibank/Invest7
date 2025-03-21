package com.invest7.view;

import com.invest7.controller.user.UserController;
import com.invest7.view.menus.simulacao.MenuPrincSimulacoesDisp;
import com.invest7.view.menus.user.MenuPrincConta;
import com.invest7.view.menus.user.MenuPrincQuest;

import java.util.Scanner;

public class MenuPrincipal {
    public static void ExibirMenuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int escolhas;

        do {
            System.out.println("1- Simulações");
            System.out.println("2- Conta");
            System.out.println("3- Refazer Questionário");
            System.out.println("4- FAQ");
            System.out.println("5- Logout");
            System.out.println("0- Sair");
            escolhas = Integer.parseInt(sc.next());

            switch (escolhas) {
                case 1:
                    MenuPrincSimulacoesDisp.exibeMenuSimDisp();
                    break;
                case 2:
                    MenuPrincConta.exibeOpConta();
                    break;
                case 3:
                    MenuPrincQuest.refazerQuest();
                    break;
                case 4:
                    FaqSimuInvestimentos.exibirFaq();
                    break;
                case 5:
                    // AuthController user = new AuthController();
                    UserController user = new UserController();
                    user.logout();
                    break;
                case 0:
                    System.out.println("Finalizando...");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        } while (escolhas != 0);

        sc.close();
    }

}
