package com.invest7.model;

public class Produto {
    private int idProduto;
    private String nome;
    private double valorInvestido;
    private double aporte;
    private int meses;

    public Produto(int idProduto) {
        this.idProduto = idProduto;
    }

    public Produto (String nome, double valorInvestido) {
        this.nome = nome;
        this.valorInvestido = valorInvestido;
    }

    public Produto (double valorInvestido, double aporte, int meses) {
        this.valorInvestido = valorInvestido;
        this.aporte = aporte;
        this.meses = meses;
    }

    public void exibir(){
        System.out.println("Produto: " + nome);
        System.out.println("Valor Investido: R$ " + valorInvestido);
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public double getAporte() {
        return aporte;
    }

    public void setAporte(double aporte) {
        this.aporte = aporte;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }
}
