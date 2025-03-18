package com.invest7.controller;
import com.invest7.dao.FiisDAO;
import com.invest7.model.Fiis;
import java.util.Scanner;
import java.text.DecimalFormat;


public class CalculadoraVariavel {

    public Fiis simularFundoImobiliario(Fiis calculadoraV) {
        FiisDAO dao = new FiisDAO();
        Fiis resultados = dao.buscarFiis(new Fiis());
        double saldoDividendos = 0, dividendoPorCota = calculadoraV.getDividendYield(),
                valorAporte = calculadoraV.getAporte(), precoCota = calculadoraV.getPrecoFiis(); ;
        int meses = calculadoraV.getMeses(), quantidadeCotas = calculadoraV.getQtdCotas(),
                reinvestir = calculadoraV.getReinvestir();

        for (int i = 1; i <= meses; i++) {
            double dividendosRecebidos = quantidadeCotas * dividendoPorCota;
            saldoDividendos += dividendosRecebidos + valorAporte;

            if (reinvestir == 1) {
                int novasCotas = (int) (saldoDividendos / precoCota);
                quantidadeCotas += novasCotas;
                saldoDividendos -= novasCotas * precoCota;
            } else {
                int novasCotasAporte = (int) (valorAporte / precoCota);
                quantidadeCotas += novasCotasAporte;
                saldoDividendos -= novasCotasAporte * precoCota;
            }
        }

        //return
    }

    public static void simularAcao(Scanner sc, DecimalFormat df) {

        System.out.print("Digite o preço de compra da ação: R$ ");
        double precoCompra = sc.nextDouble();

        System.out.print("Digite o preço de venda da ação: R$ ");
        double precoVenda = sc.nextDouble();



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