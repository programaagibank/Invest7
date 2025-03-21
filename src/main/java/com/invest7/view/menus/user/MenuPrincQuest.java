package com.invest7.view.menus.user;

import com.invest7.controller.user.UserController;
import com.invest7.controller.user.UserSession;
import com.invest7.model.UserModel;
import com.invest7.view.FormularioPerfilInvestidor;

import java.util.Scanner;

public class MenuPrincQuest {
    public static void refazerQuest() {
        Scanner sc = new Scanner(System.in);
        boolean digitoCerto = false;
        int perfil_id = 0;
        System.out.println("*********** Refazer Questionário ***********");
        while (!digitoCerto) {
            FormularioPerfilInvestidor formulario = new FormularioPerfilInvestidor();
            perfil_id =  formulario.calcularPontuacao();
            if (perfil_id > 0) {
                System.out.println("Perfil Realizado");
                digitoCerto = true;
            } else {
                System.out.println("Ocorreu um erro no cadastro, faça novamente por favor...");
                sc.next();
            }
        }
        int userId = UserSession.getLoggedInUserId();
        UserController userController = new UserController();
        UserModel userQu = new UserModel(userId, perfil_id);
        UserModel formsUp = userController.atualizarPerfil(userQu);
        if (formsUp != null ){
            System.out.println("******Perfil de investidor atualizado *****");
        } else {
            System.out.println("Erro na atualização de perfil investidor");
        }
    }
}
