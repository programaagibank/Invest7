package com.invest7.view.menus.simulacao.perfil;
import com.invest7.controller.CalculadoraRFprovisoria;

import java.util.Scanner;

public class MenuPerfilConservador {
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

    public static void exibeRF(double impRenda, int meses) {
        System.out.println("++++Renda Fixa++++");
        System.out.println("Insira o valor inicial de investimento: R$ ");
        double valorInicial = sc.nextDouble();
        System.out.println("Insira o valor do aporte mensal (digite 0 caso não " +
                "deseje realizar aporte): R$");
        double aporteRF = sc.nextDouble();

        System.out.println("+++Juros Pré Fixados+++");

        System.out.println("--CRI/CRA--");
        double rBrutoCRA = cf.calculoRendBruto(valorInicial, aporteRF, 0.07, meses);
        cf.imprIsento(rBrutoCRA, 0.07);

        System.out.println("--LCA--");
        double rBrutoLCA = cf.calculoRendBruto(valorInicial, aporteRF, 0.1478, meses);
        cf.imprIsento(rBrutoLCA,0.1478 );

        System.out.println("--LCI--");
        double rBrutoLCI = cf.calculoRendBruto(valorInicial, aporteRF, 0.1298, meses);
        cf.imprIsento(rBrutoLCI,0.1298 );

        System.out.println("--CDB Agibank--");
        double rBrutoCDB = cf.calculoRendBruto(valorInicial, aporteRF, 0.0525, meses);
        double rLiqCDB = cf.calculoRendLiq(rBrutoCDB, valorInicial, impRenda);
        cf.imprNIsento(rBrutoCDB, rLiqCDB, impRenda, 0.0525);

        System.out.println("\n--Tesouro IPCA--");
        double rBrutoTesIPCA = cf.calculoRendBruto(valorInicial, aporteRF, 0.1375, meses);
        double rLiqTesIPCA = cf.calculoRendLiq(rBrutoTesIPCA, valorInicial, impRenda);
        cf.imprNIsento(rBrutoTesIPCA, rLiqTesIPCA, impRenda, 0.1375);


        System.out.println("+++Juros Pós Fixados+++");

        System.out.println("\n--CRI/CRA--");
        double rBrutoCRApos = cf.calculoRendBruto(valorInicial, aporteRF, 0.06, meses);
        cf.imprIsento(rBrutoCRApos, 0.06);
        double rBrutoLCApos = cf.calculoRendBruto(valorInicial, aporteRF, 0.12, meses);
        cf.imprIsento(rBrutoLCApos, 0.12);

        System.out.println("--LCI--");
        double rBrutoLCIpos = cf.calculoRendBruto(valorInicial, aporteRF, 0.102, meses);
        cf.imprIsento(rBrutoLCIpos, 0.102);

        System.out.println("\n--CDB Agibank--");
        double rBrutoCDBpos = cf.calculoRendBruto(valorInicial, aporteRF, 0.105, meses);
        double rLiqCDBpos = cf.calculoRendLiq(rBrutoCDBpos, valorInicial, impRenda);
        cf.imprNIsento(rBrutoCDBpos, rLiqCDBpos, impRenda, 0.105);

        System.out.println("\n--Tesouro Selic--");
        double rBrutoTesSelic = cf.calculoRendBruto(valorInicial, aporteRF, 0.1375, meses);
        double rLiqTesSelic = cf.calculoRendLiq(rBrutoTesSelic, valorInicial, impRenda);
        cf.imprNIsento(rBrutoTesSelic, rLiqTesSelic, impRenda, 0.1375);
    }
}