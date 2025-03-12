package com.invest7.view;

import java.util.Scanner;

public class MenuSimulacaoCompleta {

    public void simulacaoCompleta(){
        Scanner sc = new Scanner(System.in);
        double capital = 0.0, aporteMensal = 0.0;
        int prazo = 0;
        boolean digitoCerto = false;
        System.out.println("-----------TELA DE SIMULACAO COMPLETA--------");

        while (!digitoCerto) {
            System.out.println("1- Digite um Capital inicial: ");
            if (sc.hasNextDouble()) { // Verifica se a entrada é um número válido
                capital = sc.nextDouble();
                digitoCerto = true; // Sai do loop se o valor for válido
            } else {
                System.out.println("Valor Incorreto, digite novamente...");
                sc.next(); // Descarta a entrada inválida
            }
        }

        digitoCerto = false;
        while (!digitoCerto) {
            System.out.println("2- Digite um valor para aporte mensal: ");
            if (sc.hasNextDouble()) { // Verifica se a entrada é um número válido
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
            if (sc.hasNextInt()) { // Verifica se a entrada é um número válido
                prazo = sc.nextInt();
                digitoCerto = true; // Sai do loop se o valor for válido
            } else {
                System.out.println("Valor Incorreto, digite novamente...");
                sc.next(); // Descarta a entrada inválida
            }
        }


        System.out.println(capital);
        System.out.println(aporteMensal);
        System.out.println(prazo );


    }
}
