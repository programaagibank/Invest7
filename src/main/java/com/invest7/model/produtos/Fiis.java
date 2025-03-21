package com.invest7.model.produtos;

public class Fiis extends Produto {
    private double aporte;
    private int qtdCotas;
    private int reinvestir;
    private double txIr;
    private double precoFiis;
    private double dividendYield;
    private double desvioCotas;
    private double desvioDividendos;
    private double saldoCotas;
    private double saldoDividendos;

    public Fiis(String nome, double valorInvestido, double txIr, double precoFiis, double dividendYield, double desvioCotas, double desvioDividendos) {
        super(nome, valorInvestido);
        this.txIr = txIr;
        this.precoFiis = precoFiis;
        this.dividendYield = dividendYield;
        this.desvioCotas = desvioCotas;
        this.desvioDividendos = desvioDividendos;
    }

    public Fiis(double valorInvestido, double aporte, int meses, int qtdCotas, int reinvestir) {
        super(valorInvestido, meses);
        this.aporte = aporte;
        this.qtdCotas = qtdCotas;
        this.reinvestir = reinvestir;
    }

    public Fiis(String nome, double precoFiis, double dividendYield, double desvioCotas, double desvioDividendos) {
        super(nome);
        this.precoFiis = precoFiis;
        this.dividendYield = dividendYield;
        this.desvioCotas = desvioCotas;
        this.desvioDividendos = desvioDividendos;
    }


    public double getAporte() {
        return aporte;
    }

    public void setAporte(double aporte) {
        this.aporte = aporte;
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


    public double getSaldoCotas() {
        return saldoCotas;
    }

    public void setSaldoCotas(double saldoCotas) {
        this.saldoCotas = saldoCotas;
    }

    public double getSaldoDividendos() {
        return saldoDividendos;
    }

    public void setSaldoDividendos(double saldoDividendos) {
        this.saldoDividendos = saldoDividendos;
    }
}
