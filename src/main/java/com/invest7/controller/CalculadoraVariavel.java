package com.invest7.controller;

import java.util.Scanner;
import java.text.DecimalFormat;


public class CalculadoraVariavel {
    static Scanner sc = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("#,##0.00");
    public static void main(String[] args) {

        simularFundoImobiliario(sc, df);
        simularAcao(sc, df);
    }

    public static void simularFundoImobiliario(Scanner sc, DecimalFormat df) {
        double saldoDividendos = 0;

        System.out.print("Digite o preço do ativo: R$ ");
        double precoCota = sc.nextDouble();

        System.out.print("Digite a quantidade de cotas compradas: ");
        int quantidadeCotas = sc.nextInt();

        System.out.print("Digite o dividendo mensal por cota: R$ ");
        double dividendoPorCota = sc.nextDouble();

        System.out.print("Digite o número de meses para a simulação: ");
        int meses = sc.nextInt();

        System.out.print("Digite o valor do aporte: R$ ");
        double valorAporte = sc.nextDouble();

        System.out.print("Deseja reinvestir os dividendos? (s/n): ");
        char reinvestir = sc.next().toLowerCase().charAt(0);

        /*System.out.println("\nSimulação do rendimento dos dividendos:\n");
        System.out.println("Mês\tCotas\tDividendos\t\tSaldo");*/


        for (int i = 1; i <= meses; i++) {
            double dividendosRecebidos = quantidadeCotas * dividendoPorCota;
            saldoDividendos += dividendosRecebidos + valorAporte;

            if (reinvestir == 's') {
                int novasCotas = (int) (saldoDividendos / precoCota);
                quantidadeCotas += novasCotas;
                saldoDividendos -= novasCotas * precoCota;
            } else {
                int novasCotasAporte = (int) (valorAporte / precoCota);
                quantidadeCotas += novasCotasAporte;
                saldoDividendos -= novasCotasAporte * precoCota;
            }

            //System.out.println(i + "\t" + quantidadeCotas + "\t\tR$ " + df.format(dividendosRecebidos) + "\t\tR$ " + df.format(saldoDividendos));
        }

        System.out.println("\nTotal de cotas ao final da simulação: " + quantidadeCotas);
        double saldoCotas = quantidadeCotas*precoCota;
        double desvioCota = saldoCotas * 0.04 ;
        System.out.println("Saldo em cotas: entre R$ " + df.format((saldoCotas - desvioCota)) + " e " + df.format((saldoCotas + desvioCota)));
        double desvioDiv = saldoDividendos * 0.04;
        System.out.println("Saldo em dividendos com desvio: R$ " + df.format(saldoDividendos - desvioDiv) + " até " + df.format(saldoDividendos + desvioDiv) + "\n");
    }

    public static void simularAcao(Scanner sc, DecimalFormat df) {

        System.out.print("Digite o preço de compra da ação: R$ ");
        double precoCompra = sc.nextDouble();

        System.out.print("Digite o preço de venda da ação: R$ ");
        double precoVenda = sc.nextDouble();

        System.out.print("Digite a quantidade de ações compradas: ");
        int quantidade = sc.nextInt();

        double custoTotal = precoCompra * quantidade;
        double valorVenda = precoVenda * quantidade;
        double saldo = valorVenda - custoTotal;

        System.out.println("\nResumo da operação:");
        System.out.println("Custo total: R$ " + df.format(custoTotal));
        System.out.println("Valor da venda: R$ " + df.format(valorVenda));

        if (saldo > 0) System.out.println("Lucro: R$ " + df.format(saldo));
        else if (saldo < 0) System.out.println("Prejuízo: R$ " + df.format(Math.abs(saldo)));
        else System.out.println("Você não teve lucro nem prejuízo.");
    }
}