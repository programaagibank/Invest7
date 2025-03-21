/*package controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import model.InvestmentCalculator;
import model.InvestmentResult;
import view.ConsoleView;

public class InvestmentController {

    private final ConsoleView view;
    private final InvestmentCalculator calculator;

    public InvestmentController() {
        this.view = new ConsoleView();
        this.calculator = new InvestmentCalculator();
    }

    public void executarSimuladorTotal() {
        System.out.println(view.NEGRITO + "=== Simulador Total de Investimentos ===" + view.RESET);

        BigDecimal valorInicial = view.lerBigDecimalPositivo("Valor inicial (R$)");
        BigDecimal aporteMensal = view.lerBigDecimalPositivo("Aporte mensal (R$)");
        int meses = view.lerInteiroPositivo("Período (meses)");
        int dias = meses * 30;

        List<InvestmentResult> resultados = new ArrayList<>();

        // Simulate all investments
        resultados.add(InvestmentCalculator.calcularPoupanca("Poupança", valorInicial, aporteMensal, meses));
        resultados.add(InvestmentCalculator.calcularCDBPrefixado("CDB Prefixado", valorInicial, aporteMensal, meses, new BigDecimal("0.1245"), true));
        resultados.add(InvestmentCalculator.calcularCDBIPCA("CDB IPCA+", valorInicial, aporteMensal, meses, new BigDecimal("0.078"), true));
        resultados.add(InvestmentCalculator.calcularCDBPosfixado("CDB Pós-fixado", valorInicial, aporteMensal, meses, new BigDecimal("1.025"), true));
        resultados.add(InvestmentCalculator.calcularLCIPrefixado("LCI/LCA Prefixado", valorInicial, aporteMensal, meses, new BigDecimal("0.1268"), false));
        resultados.add(InvestmentCalculator.calcularLCIIPCA("LCI/LCA IPCA+", valorInicial, aporteMensal, meses, new BigDecimal("0.058"), false));
        resultados.add(InvestmentCalculator.calcularLCIPosfixado("LCI/LCA Pós-fixado", valorInicial, aporteMensal, meses, new BigDecimal("0.915"), false));
        resultados.add(InvestmentCalculator.calcularTesouroPrefixado("Tesouro Prefixado", valorInicial, aporteMensal, meses, new BigDecimal("0.1487")));
        resultados.add(InvestmentCalculator.calcularTesouroIPCA("Tesouro IPCA+", valorInicial, aporteMensal, meses, new BigDecimal("0.0763")));
        resultados.add(InvestmentCalculator.calcularTesouroPosfixado("Tesouro Pós-fixado", valorInicial, aporteMensal, meses, new BigDecimal("0.0006")));

        view.imprimirCabecalho(valorInicial, meses, dias, InvestmentCalculator.TAXA_SELIC, InvestmentCalculator.CDI_ANUAL);
        view.imprimirResultados(resultados);
    }
}

 */
