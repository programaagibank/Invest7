package com.invest7.view;

import java.util.Scanner;



public class MenuSimulacaoPerfil {
    public void EscolherPerfilInvestidor(){
        Scanner sc = new Scanner(System.in);
        int escolhas = 0;

        System.out.println("Digite o numero referente ao perfil");
        System.out.println("1- Conservador");
        System.out.println("2- Moderado");
        System.out.println("3 - Arrojado");

        escolhas = sc.nextInt();

        switch (escolhas){
            case 1:
                simulacaoPerfilConservador();
                break;
            case 2:
                simulacaoPerfilModerado();
                break;
            case 3:
                simulacaoPerfilArrojado();
                break;
            default:
                break;
        }

    }
}
