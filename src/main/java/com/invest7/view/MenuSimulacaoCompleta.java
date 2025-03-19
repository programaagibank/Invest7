package com.invest7.view;
import com.invest7.controller.CalculadoraVariavel;
import com.invest7.model.Fiis;

import java.util.Scanner;

public class MenuSimulacaoCompleta {

    public void simulacaoCompleta(){
        Scanner sc = new Scanner(System.in);
        double capital = 0.0, aporteMensal = 0.0, precoCota = 0.0,dividendoPorCota = 0.0, precoCompra =0.0;
        int prazo = 0, quantidadeCotas = 0, quantidade=0, reinvestir = 0;
        boolean digitoCerto = false;

        System.out.println("-----------TELA DE SIMULACAO COMPLETA--------");

        while (!digitoCerto) {
            System.out.println("1- Digite um Capital inicial: ");
            if (sc.hasNextDouble()) {
                capital = sc.nextDouble();
                digitoCerto = true;
            } else {
                System.out.println("Valor Incorreto, digite novamente...");
                sc.next();
            }
        }

        digitoCerto = false;
        while (!digitoCerto) {
            System.out.println("2- Digite um valor para aporte mensal: ");
            if (sc.hasNextDouble()) {
                aporteMensal = sc.nextDouble();
                digitoCerto = true;
            } else {
                System.out.println("Valor Incorreto, digite novamente...");
                sc.next();
            }
        }

        digitoCerto = false;
        while (!digitoCerto) {
            System.out.println("3- Digite um prazo para a simulacao: ");
            if (sc.hasNextInt()) {
                prazo = sc.nextInt();
                digitoCerto = true;
            } else {
                System.out.println("Valor Incorreto, digite novamente...");
                sc.next();
            }
        }

        System.out.println("-----------Fundo Imob--------");
        /*digitoCerto = false;
        while (!digitoCerto) {
            System.out.println("4- Digite o preço do ativo: R$ ");
            if (sc.hasNextInt()) {
                precoCota = sc.nextInt();
                digitoCerto = true;
            } else {
                System.out.println("Valor Incorreto, digite novamente...");
                sc.next();
            }
        }*/

        digitoCerto = false;
        while (!digitoCerto) {
            System.out.println("5- Digite a quantidade de cotas compradas: ");
            if (sc.hasNextInt()) {
                quantidadeCotas = sc.nextInt();
                digitoCerto = true;
            } else {
                System.out.println("Valor Incorreto, digite novamente...");
                sc.next();
            }
        }

        /*digitoCerto = false;
        while (!digitoCerto) {
            System.out.println("6- Digite o dividendo mensal por cota: R$ ");
            if (sc.hasNextInt()) {
                dividendoPorCota = sc.nextInt();
                digitoCerto = true;
            } else {
                System.out.println("Valor Incorreto, digite novamente...");
                sc.next();
            }
        }*/

        digitoCerto = false;
        while (!digitoCerto) {
            System.out.println("7- Deseja reinvestir os dividendos?\n1-sim | 2-não: ");
            if (sc.hasNextInt()) {
                reinvestir = sc.nextInt();
                digitoCerto = true;
            } else {
                System.out.println("Valor Incorreto, digite novamente...");
                sc.next();
            }
        }

        System.out.println("-----------Ações--------");
        /*digitoCerto = false;
        while (!digitoCerto) {
            System.out.println("8- Digite o preço de compra da ação: R$ ");
            if (sc.hasNextInt()) {
                precoCompra = sc.nextDouble();
                digitoCerto = true;
            } else {
                System.out.println("Valor Incorreto, digite novamente...");
                sc.next();
            }
        }*/

        digitoCerto = false;
        while (!digitoCerto) {
            System.out.println("5- Digite a quantidade de ações compradas: ");
            if (sc.hasNextInt()) {
                quantidade = sc.nextInt();
                digitoCerto = true;
            } else {
                System.out.println("Valor Incorreto, digite novamente...");
                sc.next();
            }
        }

        CalculadoraVariavel calculadoraV = new CalculadoraVariavel();
        Fiis fiis = calculadoraV.simularFundoImobiliario(new Fiis (capital, aporteMensal, prazo, quantidadeCotas, reinvestir));

        /*System.out.println("\nTotal de cotas ao final da simulação: " + quantidadeCotas);
        double saldoCotas = quantidadeCotas*precoCota;
        double desvioCota = saldoCotas * 0.04 ;
        System.out.println("Saldo em cotas: entre R$ " + df.format((saldoCotas - desvioCota)) + " e " + df.format((saldoCotas + desvioCota)));
        double desvioDiv = saldoDividendos * 0.04;
        System.out.println("Saldo em dividendos com desvio: R$ " + df.format(saldoDividendos - desvioDiv) + " até " + df.format(saldoDividendos + desvioDiv) + "\n");*/
    }
}
