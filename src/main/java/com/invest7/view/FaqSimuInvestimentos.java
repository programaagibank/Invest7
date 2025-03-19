package com.invest7.view;

import java.util.Scanner;

class SimuladorInvestimentos {
    public void exibirFaq() {
        Scanner scanner = new Scanner(System.in);
        String[] perguntas = {
                "1 - O que é um simulador de investimentos?",
                "2 - Como calcular o retorno de um investimento?",
                "3 - Quais são os tipos de investimentos simulados?",
                "4 - O simulador garante retornos reais?",
                "5 - Posso confiar nos cálculos do simulador?",
                "6 - Voltar ao menu principal"
        };

        String[] respostas = {
                "É uma ferramenta que permite calcular os possíveis retornos de um investimento com base em diferentes parâmetros.",
                "O retorno é calculado com base no valor investido, taxa de juros e tempo de aplicação. Normalmente, usa-se a fórmula de juros compostos.",
                "O simulador pode incluir renda fixa (CDB, Tesouro Direto) e renda variável (ações, fundos imobiliários).",
                "Não, ele apenas faz projeções com base nas informações inseridas, mas o mercado pode ter variações inesperadas.",
                "Os cálculos são baseados em fórmulas matemáticas conhecidas, mas é importante considerar que investimentos envolvem riscos.",
                "Voltando ao menu principal..."
        };

        int opcao;
        do {
            System.out.println("\nFAQ - Simulador de Investimentos");
            for (String pergunta : perguntas) {
                System.out.println(pergunta);
            }

            System.out.print("\nDigite o número da pergunta para ver a resposta: ");
            opcao = scanner.nextInt();

            if (opcao >= 1 && opcao <= perguntas.length) {
                System.out.println("\n" + respostas[opcao - 1]);
            } else {
                System.out.println("\nOpção inválida. Escolha um número entre 1 e " + perguntas.length);
            }
        } while (opcao != perguntas.length);
    }
}

public class FaqSimuInvestimentos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimuladorInvestimentos simulador = new SimuladorInvestimentos();

        int opcao;
        do {
            System.out.println("\n===== Menu Principal =====");
            System.out.println("1 - Acessar FAQ");
            System.out.println("2 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    simulador.exibirFaq();
                    break;
                case 2:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Escolha 1 ou 2.");
            }
        } while (opcao != 2);

        scanner.close();
        System.out.println("\nObrigado por usar o Simulador de Investimentos!");
    }
}
