package com.invest7.model.produtos;


public class Acoes extends Produto {
    private int qtdAcoes;
    private double txIr;
    private double precoAcao;
    private double precoVenda;
    private double desvio;
    private double custoTotal;
    private double valorVenda;
    private double resultado;
    private double imposto;


    public Acoes(double valorInvestido, int meses) {
        super(valorInvestido, meses);


    }


    public Acoes(String nome, double valorInvestido, int qtdAcoes, double txIr, double precoAcao, double desvio) {
        super(nome, valorInvestido);
        this.qtdAcoes = qtdAcoes;
        this.txIr = txIr;
        this.precoAcao = precoAcao;
        this.desvio = desvio;
    }


    public Acoes(double valorInvestido, int meses, int qtdAcoes, double precoVenda) {
        super(valorInvestido, meses);
        this.qtdAcoes = qtdAcoes;
        this.precoVenda = precoVenda;
    }


    public Acoes(String nome, double txIr, double precoAcoes, double desvio) {
        super(nome);
        this.txIr = txIr;
        this.precoAcao = precoAcao;
        this.desvio = desvio;
    }


    public void mostrarRisco() {
        System.out.println("Risco do investimento: " + desvio + "% de variação");
    }


    public int getQtdAcoes() {
        return qtdAcoes;
    }


    public void setQtdAcoes(int qtdAcoes) {
        this.qtdAcoes = qtdAcoes;
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


    public double getPrecoVenda() {
        return precoVenda;
    }


    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }


    public double getDesvio() {
        return desvio;
    }


    public void setDesvio(double desvio) {
        this.desvio = desvio;
    }
}
