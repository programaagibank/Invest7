package com.invest7.model;

class RendaFixa extends Produto {
    private double rentabilidadeFixa;
    private double juros;
    private double txPrefixado;
    private double txPosfixado;

    public RendaFixa(String nome, double valorInvestido, double rentabilidadeFixa, double juros, double txPrefixado, double txPosfixado) {
        super(nome, valorInvestido);
        this.rentabilidadeFixa = rentabilidadeFixa;
        this.juros = juros;
        this.txPrefixado = txPrefixado;
        this.txPosfixado = txPosfixado;
    }

    public void calcularRendimento() {
        double rendimento = getValorInvestido() * (rentabilidadeFixa / 100);
        System.out.println("Rendimento Anual: R$ " + rendimento);
    }

    public double getRentabilidadeFixa() {
        return rentabilidadeFixa;
    }

    public void setRentabilidadeFixa(double rentabilidadeFixa) {
        this.rentabilidadeFixa = rentabilidadeFixa;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public double getTxPrefixado() {
        return txPrefixado;
    }

    public void setTxPrefixado(double txPrefixado) {
        this.txPrefixado = txPrefixado;
    }

    public double getTxPosfixado() {
        return txPosfixado;
    }

    public void setTxPosfixado(double txPosfixado) {
        this.txPosfixado = txPosfixado;
    }
}
