package com.invest7.model;

class Teste {
    public static void main(String[] args) {
        RendaFixa rf = new RendaFixa("CDB", 1000, 1, 1, 0, 0);
        rf.exibir();
        rf.calcularRendimento();
        System.out.println();

        Acoes acoes = new Acoes("Ações XYZ", 2000, 15, 38, 1.5);
        acoes.exibir();
        acoes.mostrarRisco();
        System.out.println();

        Fiis fii = new Fiis("Fundos Imobiliário ABC", 5000, 7, 78, 0, 1.5, 2.5);
        fii.exibir();
        fii.calcularDividendos();
    }
}