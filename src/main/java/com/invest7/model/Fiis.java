package com.invest7.model;
class Fiis extends Produto {
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
}
