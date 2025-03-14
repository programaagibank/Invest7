package com.invest7.model;

public class Produto {
    private String nome;
    private double valorInvestido;

    public Produto (String nome, double valorInvestido){
        this.nome = nome;
        this.valorInvestido = valorInvestido;
    }

    public void exibir(){
        System.out.println("Produto: " + nome);
        System.out.println("Valor Investido: R$ " + valorInvestido);
    }
    public String getNome() {
        return nome;
    }

    public double getValorInvestido() {
        return valorInvestido;
    }
}
