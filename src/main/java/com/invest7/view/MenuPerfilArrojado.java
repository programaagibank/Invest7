package com.invest7.view;

import com.invest7.controller.CalculadoraRFprovisoria;
import com.invest7.controller.CalculadoraVariavel;
import java.util.Scanner;

public class MenuPerfilArrojado {
    static Scanner sc = new Scanner(System.in);
    static CalculadoraRFprovisoria cf = new CalculadoraRFprovisoria();

    public static void simulacaoPerfilArrojado() {

        String[] pacote = {"CRI", "LCA/LCI", "CDB", // RF - 30%
                "PETR4", "SPCE3", "VIVA3 ", //Ações - 30%
                "XPLG11", "LVBI11", "TGAR11", "AAZQ11"}; //FIIs - 40%

        System.out.println("=====Simulação de Perfil Arrojado=====");
        System.out.println("Digite o número de meses para a simulação: ");
        int meses = sc.nextInt();
        double impRenda = cf.calculoImpRenda(meses);
        exibeRF(impRenda, meses);

        double impRendaRV = 0.15;

        /* Os métodos são provisórios*/

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
        double rBrutoCRI = cf.calculoRendBruto(valorInicial, aporteRF, 0.07, meses);
        cf.imprIsento(rBrutoCRI,0.07 );

        System.out.println("--LCA--");
        double rBrutoLCA = cf.calculoRendBruto(valorInicial, aporteRF, 0.1478, meses);
        cf.imprIsento(rBrutoLCA,0.1478 );

        System.out.println("--CDB Agibank--");
        double rBrutoCDB = cf.calculoRendBruto(valorInicial, aporteRF, 0.125, meses);
        double rLiqCDB = cf.calculoRendLiq(rBrutoCDB, valorInicial, impRenda);
        cf.imprNIsento(rBrutoCDB, rLiqCDB, impRenda, 0.125);

        System.out.println("+++Juros Pós Fixados+++");
        System.out.println("\n--CRI--");
        double rBrutoCRIpos = cf.calculoRendBruto(valorInicial, aporteRF, 0.06, meses);
        cf.imprIsento(rBrutoCRIpos,0.06 );
        System.out.println("--LCA--");
        double rBrutoLCApos = cf.calculoRendBruto(valorInicial, aporteRF, 0.12, meses);
        cf.imprIsento(rBrutoLCApos,0.12 );
        System.out.println("\n--CDB Agibank--");
        double rBrutoCDBpos = cf.calculoRendBruto(valorInicial, aporteRF, 0.105, meses);
        double rLiqCDBpos = cf.calculoRendLiq(rBrutoCDBpos, valorInicial, impRenda);
        cf.imprNIsento(rBrutoCDBpos, rLiqCDBpos, impRenda, 0.105);
    }

    public static void exibeRV(double impRendaRV, int meses) {
        System.out.println("++++Renda Variável++++");
        System.out.println("+++Fundos Imobiliários+++");



    }
}

