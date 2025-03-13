package com.invest7.view;

import com.invest7.controller.CalculadoraRFprovisoria;
import com.invest7.controller.CalculadoraVariavel;
import java.util.Scanner;

public class MenuPerfilModerado {
    static Scanner sc = new Scanner(System.in);
    static CalculadoraRFprovisoria cf = new CalculadoraRFprovisoria();

    public static void simulacaoPerfilModerado() {

        String[] pacote = {"CRA","LCI", "CDB", "Tesouro Selic", "Tesouro IPCA+",  // RF - 50%
                "VIVA3", "LREN3", //Ações - 20%
                "XPLG11", "TGAR11", "MXRF11"}; //FIIs - 30%

        System.out.println("=====Simulação de Perfil Moderado=====");
        System.out.println("Digite o número de meses para a simulação: ");
        int meses = sc.nextInt();
        double impRenda = cf.calculoImpRenda(meses);
    }
}
}
