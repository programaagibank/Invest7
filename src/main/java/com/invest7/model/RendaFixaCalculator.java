package com.invest7.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class RendaFixaCalculator {

    // Current market rates (Consider moving these to a configuration or service class in a more complex application)
    public static final BigDecimal TAXA_SELIC = new BigDecimal("0.0814");  // 8.14%
    public static final BigDecimal TR_MENSAL = new BigDecimal("0.0001");   // 0.01%
    public static final BigDecimal CDI_ANUAL = new BigDecimal("0.10");     // 10%
    public static final BigDecimal IPCA_ANUAL = new BigDecimal("0.05");    // 5%

    public static RendaFixa_Result calcularPoupanca(String nome, BigDecimal valorInicial, BigDecimal aporteMensal, int meses) {
        int dias = meses * 30;
        BigDecimal taxaMensal;
        if (TAXA_SELIC.compareTo(new BigDecimal("0.085")) > 0) {
            taxaMensal = new BigDecimal("0.005").add(TR_MENSAL);
        } else {
            taxaMensal = TAXA_SELIC.multiply(new BigDecimal("0.7")).divide(BigDecimal.valueOf(12), MathContext.DECIMAL128).add(TR_MENSAL);
        }

        BigDecimal average = calcularValorFuturo(valorInicial, aporteMensal, meses, taxaMensal, false, dias);
        BigDecimal pessimistic = calcularValorFuturo(valorInicial, aporteMensal, meses, taxaMensal.multiply(new BigDecimal("0.9")), false, dias);
        BigDecimal optimistic = calcularValorFuturo(valorInicial, aporteMensal, meses, taxaMensal.multiply(new BigDecimal("1.1")), false, dias);

        String percPess = calcularPercentual(pessimistic, valorInicial, aporteMensal, meses);
        String percAvg = calcularPercentual(average, valorInicial, aporteMensal, meses);
        String percOpt = calcularPercentual(optimistic, valorInicial, aporteMensal, meses);

        return new RendaFixa_Result(nome, pessimistic, average, optimistic, percPess, percAvg, percOpt);
    }

    public static RendaFixa_Result calcularCDBPrefixado(String nome, BigDecimal valorInicial, BigDecimal aporteMensal, int meses, BigDecimal taxaAnual, boolean taxavel) {
        BigDecimal taxaMensal = taxaAnual.divide(BigDecimal.valueOf(12), MathContext.DECIMAL128);
        int dias = meses * 30;

        BigDecimal average = calcularValorFuturo(valorInicial, aporteMensal, meses, taxaMensal, taxavel, dias);
        BigDecimal pessimistic = calcularValorFuturo(valorInicial, aporteMensal, meses, taxaMensal.multiply(new BigDecimal("0.9")), taxavel, dias);
        BigDecimal optimistic = calcularValorFuturo(valorInicial, aporteMensal, meses, taxaMensal.multiply(new BigDecimal("1.1")), taxavel, dias);

        String percPess = calcularPercentual(pessimistic, valorInicial, aporteMensal, meses);
        String percAvg = calcularPercentual(average, valorInicial, aporteMensal, meses);
        String percOpt = calcularPercentual(optimistic, valorInicial, aporteMensal, meses);

        return new RendaFixa_Result(nome, pessimistic, average, optimistic, percPess, percAvg, percOpt);
    }

    public static RendaFixa_Result calcularCDBIPCA(String nome, BigDecimal valorInicial, BigDecimal aporteMensal, int meses, BigDecimal spread, boolean taxavel) {
        BigDecimal taxaAnual = IPCA_ANUAL.add(spread);
        return calcularCDBPrefixado(nome, valorInicial, aporteMensal, meses, taxaAnual, taxavel);
    }

    public static RendaFixa_Result calcularCDBPosfixado(String nome, BigDecimal valorInicial, BigDecimal aporteMensal, int meses, BigDecimal percentualCDI, boolean taxavel) {
        BigDecimal taxaAnual = CDI_ANUAL.multiply(percentualCDI);
        return calcularCDBPrefixado(nome, valorInicial, aporteMensal, meses, taxaAnual, taxavel);
    }

    public static RendaFixa_Result calcularLCIPrefixado(String nome, BigDecimal valorInicial, BigDecimal aporteMensal, int meses, BigDecimal taxaAnual, boolean taxavel) {
        return calcularCDBPrefixado(nome, valorInicial, aporteMensal, meses, taxaAnual, taxavel);
    }

    public static RendaFixa_Result calcularLCIIPCA(String nome, BigDecimal valorInicial, BigDecimal aporteMensal, int meses, BigDecimal spread, boolean taxavel) {
        return calcularCDBIPCA(nome, valorInicial, aporteMensal, meses, spread, taxavel);
    }

    public static RendaFixa_Result calcularLCIPosfixado(String nome, BigDecimal valorInicial, BigDecimal aporteMensal, int meses, BigDecimal percentualCDI, boolean taxavel) {
        return calcularCDBPosfixado(nome, valorInicial, aporteMensal, meses, percentualCDI, taxavel);
    }

    public static RendaFixa_Result calcularTesouroPrefixado(String nome, BigDecimal valorInicial, BigDecimal aporteMensal, int meses, BigDecimal taxaAnual) {
        return calcularCDBPrefixado(nome, valorInicial, aporteMensal, meses, taxaAnual, true);
    }

    public static RendaFixa_Result calcularTesouroIPCA(String nome, BigDecimal valorInicial, BigDecimal aporteMensal, int meses, BigDecimal spread) {
        BigDecimal taxaAnual = IPCA_ANUAL.add(spread);
        return calcularCDBPrefixado(nome, valorInicial, aporteMensal, meses, taxaAnual, true);
    }

    public static RendaFixa_Result calcularTesouroPosfixado(String nome, BigDecimal valorInicial, BigDecimal aporteMensal, int meses, BigDecimal spread) {
        BigDecimal taxaAnual = CDI_ANUAL.add(spread);
        return calcularCDBPrefixado(nome, valorInicial, aporteMensal, meses, taxaAnual, true);
    }

    private static BigDecimal calcularValorFuturo(BigDecimal valorInicial, BigDecimal aporteMensal, int meses, BigDecimal taxaMensal, boolean taxavel, int dias) {
        BigDecimal totalInvestido = valorInicial.add(aporteMensal.multiply(BigDecimal.valueOf(meses)));
        BigDecimal balance = valorInicial;
        for (int i = 0; i < meses; i++) {
            BigDecimal juros = balance.multiply(taxaMensal, MathContext.DECIMAL128);
            balance = balance.add(juros).add(aporteMensal);
        }
        if (taxavel) {
            BigDecimal rendimento = balance.subtract(totalInvestido);
            BigDecimal aliquota = getAliquotaIR(dias);
            BigDecimal imposto = rendimento.multiply(aliquota, MathContext.DECIMAL128);
            balance = balance.subtract(imposto);
        }
        return balance.setScale(2, RoundingMode.HALF_UP);
    }

    private static BigDecimal getAliquotaIR(int dias) {
        if (dias <= 180) {
            return new BigDecimal("0.225");
        } else if (dias <= 360) {
            return new BigDecimal("0.20");
        } else if (dias <= 720) {
            return new BigDecimal("0.175");
        } else {
            return new BigDecimal("0.15");
        }
    }

    private static String calcularPercentual(BigDecimal montante, BigDecimal valorInicial, BigDecimal aporteMensal, int meses) {
        BigDecimal totalInvestido = valorInicial.add(aporteMensal.multiply(BigDecimal.valueOf(meses)));
        BigDecimal rendimento = montante.subtract(totalInvestido);
        BigDecimal percentual = rendimento.divide(totalInvestido, 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
        return String.format("%.2f%%", percentual);
    }
}