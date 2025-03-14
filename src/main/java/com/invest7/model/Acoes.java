package com.invest7.model;

class Acoes extends Produto {
    private double txIr;
    private double precoAcao;
    private double desvio;

    public Acoes(String nome, double valorInvestido, double txIr, double precoAcao, double desvio) {
        super(nome, valorInvestido);
        this.txIr = txIr;
        this.precoAcao = precoAcao;
        this.desvio = desvio;
    }

    public void mostrarRisco() {
        System.out.println("Risco do investimento: " + desvio + "% de variação");
    }

    public double getTxIr() {
        return txIr;
    }

    public void setTxIr(double txIr) {
        this.txIr = txIr;
    }

    public double getPrecoAcao() {
        return precoAcao;
    }

    public void setPrecoAcao(double precoAcao) {
        this.precoAcao = precoAcao;
    }

    public double getDesvio() {
        return desvio;
    }

    public void setDesvio(double desvio) {
        this.desvio = desvio;
    }
}