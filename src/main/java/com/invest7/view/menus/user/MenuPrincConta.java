package com.invest7.view.menus.user;
import com.invest7.controller.user.UserController;
import com.invest7.model.UserModel;

import java.util.Scanner;

public class MenuPrincConta {
    public static void exibeOpConta() {
        Scanner sc = new Scanner(System.in);
        int op;
        System.out.println("*********** Conta ***********");
        do {
            System.out.println("1- Visualizar seus dados cadastrados");
            System.out.println("2- Atualizar seus dados cadastrais");
            System.out.println("3- Deletar Conta");
            System.out.println("0- Voltar ao menu principal");
            op = Integer.parseInt(sc.next());
            switch (op) {
                case 1:
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
                        System.out.println("Perfil de investidor: " + userR.getDescricao_perfil());
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;
                case 2:
                    MenuUptade menuUptade = new MenuUptade();
                    menuUptade.MenuUptade();
                    break;
                case 3:
                    MenuDelete menuDelete = new MenuDelete();
                    menuDelete.confirmarDelete();
                    break;
            }
        } while (op != 0);
    }
}
