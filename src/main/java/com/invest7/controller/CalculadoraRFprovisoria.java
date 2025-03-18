package com.invest7.controller;

import java.text.DecimalFormat;

public class CalculadoraRFprovisoria {
    static DecimalFormat df = new DecimalFormat("#,##0.00");
    public static double calculoImpRenda(int meses) {
        double aliqIR;
        if (meses <= 6) aliqIR = 0.225;
        else if (meses <= 12) aliqIR = 0.20;
        else if (meses <= 25) aliqIR = 0.175;
        else aliqIR = 0.15;
        return aliqIR;
    }

    //calculadora RF provisória
    public static double calculoRendBruto(double valorInicial, double aporteM, double tx, int meses) {
        return valorInicial * Math.pow(1 + tx, meses) + aporteM * ((Math.pow(1 + tx, meses) - 1) / tx);
    }

    public static double calculoRendLiq(double rendBrutoRF, double valorInicial, double iR) {
        return rendBrutoRF - ((rendBrutoRF - valorInicial) * iR);
    }

    public static void imprIsento(double rendBruto, double tx) {
        System.out.println("\nTaxa: " + df.format(tx * 100) + "\nRendimento Líquido: R$" + df.format(rendBruto) +
                "\nImposto de Renda: Isento\n");

    }

    public static void imprNIsento(double rendBruto, double rendLiq, double iR, double tx){
        System.out.println("Taxa:" + df.format(tx*100)+ "\nRendimento Bruto: R$" +
                df.format(rendBruto) + "\nImposto de Renda: " + df.format(iR*100)
                +"%\nRendimento Liquido: R$" + df.format(rendLiq) +"\n" );
    }
}
