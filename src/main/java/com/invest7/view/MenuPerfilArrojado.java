package com.invest7.view;

import com.invest7.controller.CalculadoraRFprovisoria;
import com.invest7.controller.CalculadoraVariavel;
import java.util.Scanner;

public class MenuPerfilArrojado {
    static Scanner sc = new Scanner(System.in);
    static CalculadoraRFprovisoria cF = new CalculadoraRFprovisoria();

    public static void simulacaoPerfilArrojado() {

        String[] pacote = {"CRI", "LCA/LCI", "CDB", // RF - 30%
                "PETR4", "SPCE3", "VIVA3 ", //Ações - 30%
                "XPLG11", "LVBI11", "TGAR11", "AAZQ11"}; //FIIs - 40%

        System.out.println("=====Simulação de Perfil Arrojado=====");
        System.out.println("Digite o número de meses para a simulação: ");
        int meses = sc.nextInt();
        double impRenda = cF.calculoImpRenda(meses);
        exibeRF(impRenda, meses);

        /* - Os métodos ainda vão mudar, porque vamos usar os valores direto do BD e imprimirá uma matriz
           - Precisa definir os preços das ações e cotas FIIs para acrescentar os métodos de RV*/


    }

    public static void exibeRF (double impRenda, int meses) {
        System.out.println("++++Renda Fixa++++");
        System.out.println("Insira o valor inicial de investimento: R$ ");
        double valorInicial = sc.nextDouble();
        System.out.println("Insira o valor do aporte mensal (digite 0 caso não " +
                "deseje realizar aporte): R$");
        double aporteRF = sc.nextDouble();

        System.out.println("+++Juros Pré Fixados+++");
        System.out.println("--CRI--");
        double rBrutoCRI = cF.calculoRendBruto(valorInicial, aporteRF, 0.07, meses);
        cF.imprIsento(rBrutoCRI,0.07 );
        System.out.println("--LCA--");
        double rBrutoLCA = cF.calculoRendBruto(valorInicial, aporteRF, 0.1478, meses);
        cF.imprIsento(rBrutoLCA,0.1478 );
        System.out.println("--CDB Agibank--");
        double rBrutoCDB = cF.calculoRendBruto(valorInicial, aporteRF, 0.125, meses);
        double rLiqCDB = cF.calculoRendLiq(rBrutoCDB, valorInicial, impRenda);
        cF.imprNIsento(rBrutoCDB, rLiqCDB, impRenda, 0.125);

        System.out.println("+++Juros Pós Fixados+++");
        System.out.println("\n--CRI--");
        double rBrutoCRIpos = cF.calculoRendBruto(valorInicial, aporteRF, 0.06, meses);
        cF.imprIsento(rBrutoCRIpos,0.06 );
        System.out.println("\n--CDB Agibank--");
        double rBrutoCDBpos = cF.calculoRendBruto(valorInicial, aporteRF, 0.105, meses);
        double rLiqCDBpos = cF.calculoRendLiq(rBrutoCDBpos, valorInicial, impRenda);
        cF.imprNIsento(rBrutoCDBpos, rLiqCDBpos, impRenda, 0.105);
    }

    public static void exibeRV(double impRenda, int meses) {
        System.out.println("++++Renda Variável++++");
        System.out.println("+++Fundos Imobiliários+++");


    }
}

