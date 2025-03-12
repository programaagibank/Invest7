package com.invest7;

import com.invest7.util.ConnectionFactory;
import com.invest7.view.MenuInicial;

public class Main {
    public static final String RESET = "\033[0m";
    public static final String CIANO = "\033[36m";
    public static final String VERMELHO = "\033[31m";
    public static final String AZUL = "\033[34m";
    public static final String VERDE = "\033[32m";
    public static final String AMARELO = "\033[33m";
    public static final String ROXO = "\033[35m";
    public static final String NEGRITO = "\033[1m";

    public static void main(String[] args) {
        MenuInicial menuInicial = new MenuInicial();

        System.out.println(CIANO + " ||=========================================================||" + RESET);
        System.out.println(CIANO + " ***********Olá. Bem vindo ao Invest7: *********** " + RESET);

        menuInicial.exibirMenuInicial();
        System.out.println();
        System.out.println(VERMELHO + " ||=========================================================||" + RESET);
        System.out.println(VERMELHO + " Obrigado por usar o nosso sistema, volte mais vezes!! " + RESET);


    }
}
