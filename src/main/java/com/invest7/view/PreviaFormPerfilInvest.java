package com.invest7.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PreviaFormPerfilInvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] questoes = {
                "1. Qual seu conhecimento sobre investimentos?\nA) Nenhum\nB) Básico\nC) Avançado",
                "2. Quanto tempo pretende deixar o dinheiro investido?\nA) Menos de 1 ano\nB) 1 a 5 anos\nC) Mais de 5 anos",
                "3. Como você reagiria a uma queda de 10% no investimento?\nA) Venderia tudo\nB) Esperaria recuperar\nC) Compraria mais",
                "4. O que você espera do seu investimento a longo prazo?\nA) Segurança\nB) Equilíbrio entre risco e retorno\nC) Alta rentabilidade",
                "5. Qual o percentual da sua renda mensal que pode ser investido?\nA) Menos de 10%\nB) Entre 10% e 30%\nC) Mais de 30%"
        };

        Map<String, Integer> pontuacoes = new HashMap<>();
        pontuacoes.put("A", 0);  // 8
        pontuacoes.put("B", 50); // 9
        pontuacoes.put("C", 100); // 10

        int pontuacaoTotal = 0;

        for (String questao : questoes) {
            System.out.println(questao); // 13
            String resposta;

            do {
                System.out.print("Sua resposta (A, B ou C): ");
                resposta = scanner.next().toUpperCase();
            } while (!pontuacoes.containsKey(resposta));

            pontuacaoTotal += pontuacoes.get(resposta);
        }

        int mediaPontuacao = pontuacaoTotal / questoes.length;

        System.out.println("\n===== Resultado do Perfil de Investidor =====");
        System.out.println("Pontuação total: " + mediaPontuacao);

        if (mediaPontuacao <= 33) {
            System.out.println("Perfil Conservador: Você valoriza estabilidade e baixa tolerância ao risco.");
        } else if (mediaPontuacao <= 66) {
            System.out.println("Perfil Moderado: Você busca um equilíbrio entre segurança e crescimento.");
        } else if (mediaPontuacao <= 100) {
            System.out.println("Perfil Arrojado: Você tem alta tolerância ao risco e foca na rentabilidade.");
        } else {
            System.out.println("Perfil Indefinido: Tente refazer o teste.");
        }

        scanner.close();
    }
}
