package com.invest7.view;
import com.invest7.controller.CalculadoraRFprovisoria;
import com.invest7.controller.CalculadoraVariavel;
import java.util.Scanner;

public class MenuPerfilConservador{
    static Scanner sc = new Scanner(System.in);
    static CalculadoraRFprovisoria cf = new CalculadoraRFprovisoria();

    public static void simulacaoPerfilConservador() {

        String[] pacote = {"CRI", "CRA", "LCA", "LCI", "CDB", "Tesouro Selic", "Tesouro IPCA+",  // RF - 70%
                "VIVA3 ", //Ações - 10%
                "XPLG11", "TGAR11"}; //FIIs - 20%

        System.out.println("=====Simulação de Perfil Conservador=====");
        System.out.println("Digite o número de meses para a simulação: ");
        int meses = sc.nextInt();
        double impRenda = cf.calculoImpRenda(meses);
    }
}