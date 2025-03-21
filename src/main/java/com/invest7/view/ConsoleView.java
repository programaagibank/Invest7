package com.invest7.view;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import com.invest7.model.RendaFixa_Result;

public class ConsoleView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    // ANSI color codes
    private static final String AZUL = "\033[34m";
    private static final String VERDE = "\033[32m";
    private static final String VERMELHO = "\033[31m";
    private static final String AMARELO = "\033[33m";
    private static final String ROXO = "\033[35m";
    private static final String CIANO = "\033[36m";
    private static final String RESET = "\033[0m";
    private static final String NEGRITO = "\033[1m";

    public BigDecimal lerBigDecimalPositivo(String mensagem) {
        BigDecimal valor;
        do {
            System.out.print(mensagem + ": ");
            String input = scanner.nextLine().replace(",", ".");
            try {
                valor = new BigDecimal(input);
                if (valor.compareTo(BigDecimal.ZERO) < 0) {
                    System.out.println("Valor deve ser positivo.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido.");
            }
        } while (true);
        return valor;
    }

    public int lerInteiroPositivo(String mensagem) {
        int valor;
        do {
            System.out.print(mensagem + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Valor inválido.");
                scanner.next();
            }
            valor = scanner.nextInt();
            if (valor <= 0) {
                System.out.println("Valor deve ser positivo.");
            } else {
                break;
            }
        } while (true);
        scanner.nextLine(); // Consume newline
        return valor;
    }

    public void imprimirCabecalho(BigDecimal valorInicial, int meses, int dias, BigDecimal taxaSelic, BigDecimal cdiAnual) {
        System.out.println("\n" + AZUL + NEGRITO + "*******************************************" + RESET);
        System.out.println(AZUL + "Valor da Aplicação: " + NEGRITO + nf.format(valorInicial) + RESET);
        System.out.println(AZUL + "Vencimento: " + NEGRITO + meses + " meses" + RESET);
        System.out.println(AZUL + "Tipo de período: Mensal" + RESET);
        System.out.println(AZUL + "Dias: " + NEGRITO + dias + RESET);
        System.out.println(AZUL + "Taxa SELIC: " + NEGRITO + formatarPercentual(taxaSelic) + " ao ano" + RESET);
        System.out.println(AZUL + "CDB/RDB/LC: " + NEGRITO + formatarPercentual(cdiAnual) + " DI" + RESET);
        System.out.println(AZUL + "LCI/LCA: " + NEGRITO + formatarPercentual(cdiAnual.multiply(new BigDecimal("0.915"))) + " DI" + RESET);
        System.out.println(AZUL + NEGRITO + "*******************************************" + RESET);
    }

    public void imprimirResultados(List<RendaFixa_Result> resultados) {
        for (InvestmentResult res : resultados) {
            System.out.println("\n" + ROXO + NEGRITO + res.getName() + RESET);
            System.out.println(VERDE + "Proj. Pessimista" + RESET);
            System.out.println(NEGRITO + nf.format(res.getPessimistic()) + RESET);
            System.out.println("+ " + nf.format(res.getPessimistic().subtract(calcularTotalInvestido(res.getPessimistic(), res.getAverage(), res.getOptimistic()))) + " • " + res.getPercentPessimistic() + "%" + RESET);
            System.out.println(AMARELO + "Proj. Média" + RESET);
            System.out.println(NEGRITO + nf.format(res.getAverage()) + RESET);
            System.out.println("+ " + nf.format(res.getAverage().subtract(calcularTotalInvestido(res.getPessimistic(), res.getAverage(), res.getOptimistic()))) + " • " + res.getPercentAverage() + "%" + RESET);
            System.out.println(VERMELHO + "Proj. Otimista" + RESET);
            System.out.println(NEGRITO + nf.format(res.getOptimistic()) + RESET);
            System.out.println("+ " + nf.format(res.getOptimistic().subtract(calcularTotalInvestido(res.getPessimistic(), res.getAverage(), res.getOptimistic()))) + " • " + res.getPercentOptimistic() + "%" + RESET);
            System.out.println(CIANO + "__________________________________________" + RESET);
        }
    }

    private BigDecimal calcularTotalInvestido(BigDecimal... values) {
        BigDecimal total = BigDecimal.ZERO;
        for (BigDecimal val : values) {
            total = total.add(val);
        }
        return total.divide(new BigDecimal(values.length), java.math.MathContext.DECIMAL128);
    }

    private String formatarPercentual(BigDecimal valor) {
        return String.format("%.2f%%", valor.multiply(BigDecimal.valueOf(100)));
    }
}

