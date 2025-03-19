package com.invest7.model;
public class Fiis extends Produto {
    private int qtdCotas;
    private int reinvestir;
    private double txIr;
    private double precoFiis;
    private double dividendYield;
    private double desvioCotas;
    private double desvioDividendos;

    public Fiis(String nome, double valorInvestido, double txIr, double precoFiis, double dividendYield, double desvioCotas, double desvioDividendos) {
        super(nome, valorInvestido);
        this.txIr = txIr;
        this.precoFiis = precoFiis;
        this.dividendYield = dividendYield;
        this.desvioCotas = desvioCotas;
        this.desvioDividendos = desvioDividendos;
    }

    public Fiis(double valorInvestido, double aporte, int meses, int qtdCotas, int reinvestir) {
        super(valorInvestido, aporte, meses);
        this.qtdCotas = qtdCotas;
        this.reinvestir = reinvestir;
    }

    public void calcularDividendos() {
        double dividendos = getValorInvestido() * (dividendYield / 100);
        System.out.println("Dividendos Mensais: R$ " + dividendos);
    }

    public double getTxIr() {
        return txIr;
    }

    public void setTxIr(double txIr) {
        this.txIr = txIr;
    }

    public double getPrecoFiis() {
        return precoFiis;
    }

    public void setPrecoFiis(double precoFiis) {
        this.precoFiis = precoFiis;
    }

    public double getDividendYield() {
        return dividendYield;
    }

    public void setDividendYield(double dividendYield) {
        this.dividendYield = dividendYield;
    }

    public double getDesvioCotas() {
        return desvioCotas;
    }

    public void setDesvioCotas(double desvioCotas) {
        this.desvioCotas = desvioCotas;
    }

    public double getDesvioDividendos() {
        return desvioDividendos;
    }

    public void setDesvioDividendos(double desvioDividendos) {
        this.desvioDividendos = desvioDividendos;
    }

    public int getQtdCotas() {
        return qtdCotas;
    }

    public void setQtdCotas(int qtdCotas) {
        this.qtdCotas = qtdCotas;
    }

    public int getReinvestir() {
        return reinvestir;
    }

    public void setReinvestir(int reinvestir) {
        this.reinvestir = reinvestir;
    }
}
