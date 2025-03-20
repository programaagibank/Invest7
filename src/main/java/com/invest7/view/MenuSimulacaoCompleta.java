package com.invest7.view;
import com.invest7.controller.CalculadoraVariavel;
import com.invest7.model.Acoes;
import com.invest7.model.Fiis;

import java.util.List;
import java.util.Scanner;

public class MenuSimulacaoCompleta {

    public void simulacaoCompleta(){
        Scanner sc = new Scanner(System.in);
        double capital = 0.0, aporteMensal = 0.0, precoCota = 0.0,
                dividendoPorCota = 0.0, precoCompra =0.0, precoVenda = 0.0;
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
            System.out.println("4- Digite a quantidade de cotas compradas: ");
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
            System.out.println("5- Deseja reinvestir os dividendos?\n1-sim | 2-não: ");
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
            System.out.println("6- Digite a quantidade de ações compradas: ");
            if (sc.hasNextInt()) {
                quantidade = sc.nextInt();
                digitoCerto = true;
            } else {
                System.out.println("Valor Incorreto, digite novamente...");
                sc.next();
            }
        }

        digitoCerto = false;
        while (!digitoCerto) {
            System.out.println("7- Digite o preço de venda da ação: R$ ");
            if (sc.hasNextInt()) {
                precoVenda = sc.nextDouble();
                digitoCerto = true;
            } else {
                System.out.println("Valor Incorreto, digite novamente...");
                sc.next();
            }
        }

        CalculadoraVariavel calculadoraV = new CalculadoraVariavel();
        List <Fiis> fiis = calculadoraV.simularFundoImobiliario(new Fiis (capital, aporteMensal,
                prazo, quantidadeCotas, reinvestir));

        for (Fiis resultados : fiis){
            System.out.println("nome" + resultados.getNome()
                    + "Saldo cotas" + resultados.getSaldoCotas()
                    + "Saldo Dividendos" + resultados.getSaldoDividendos());

        }

        //Acoes acoes = calculadoraV.simularAcao(new Acoes(capital, prazo, quantidade, precoVenda))


         //Ações
        /*
        if (saldo > 0) System.out.println("Lucro: R$ " + df.format(saldo));
        else if (saldo < 0) System.out.println("Prejuízo: R$ " + df.format(Math.abs(saldo)));
        else System.out.println("Você não teve lucro nem prejuízo.");*/





    }
}
