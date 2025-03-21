package com.invest7.view.menus;

import com.invest7.view.CadastroView;
import com.invest7.view.LoginView;
import com.invest7.view.PreviaFormPerfilInvest;

import java.util.Scanner;

public class MenuInicial {
    public void exibirMenuInicial(){
        Scanner sc = new Scanner(System.in);

        int escolhas;

        do {
            System.out.println("1- Fazer login");
            System.out.println("2- Fazer Cadastro");
            System.out.println("3- Fazer Prévia de Simulação");
            System.out.println("4- Fazer Prévia de questionário");
            System.out.println("0- Sair");
            escolhas = Integer.parseInt(sc.next());

            switch (escolhas) {
                case 1:
                    LoginView loginView = new LoginView();
                    loginView.exibirLogin();
                    break;
                case 2:
                    CadastroView cadastroView = new CadastroView();
                    cadastroView.CriarUsuario();
                    break;
                case 3:
                    // Código para fazer prévia de simulado
                    System.out.println("Prévia de Simulado");
                    break;
                case 4:
                    PreviaFormPerfilInvest previaFomrs = new PreviaFormPerfilInvest();
                    previaFomrs.previaForms();

                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (escolhas != 0);

        sc.close();

    }

}
