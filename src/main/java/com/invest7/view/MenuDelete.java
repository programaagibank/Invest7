package com.invest7.view;

import com.invest7.controller.UserDropController;

import java.util.Scanner;

public class MenuDelete {

    public void confirmarDelete(){
        UserDropController user = new UserDropController();
        int escolhas =0;
        boolean deuCerto = false;
        String email = null, senha = null;
        Scanner sc = new Scanner(System.in);
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        MenuInicial menuInicial = new MenuInicial();


        System.out.println("Você tem certeza que quer excluir sua conta?? ");
        System.out.println("1- Sim");
        System.out.println("2- Não");
        escolhas = sc.nextInt();


        sc.nextLine();
        if (escolhas == 1){
            System.out.println("Confirme seu email: ");
            email = sc.nextLine();

            System.out.println("Confirme sua senha: ");
            senha = sc.nextLine();

            deuCerto = user.deletarConta(email, senha);

            if (!deuCerto){
                System.out.println("****erro ao excluir a conta...*****");
                menuPrincipal.ExibirMenuPrincipal();
            } else {
                System.out.println("**** Conta Deleta ****");
                menuInicial.exibirMenuInicial();
            }

        } else {
            System.out.println("Voce escolheu não deletar...");
            System.out.println("**** você será redirecionado ao menu principal novamente... ****");
            menuPrincipal.ExibirMenuPrincipal();
        }


    }
}
