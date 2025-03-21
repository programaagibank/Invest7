package com.invest7.controller;
import com.invest7.dao.FiisDAO;
import com.invest7.model.produtos.Fiis;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraVariavel {

    public List<Fiis> simularFundoImobiliario(Fiis calculadoraV) {
        FiisDAO dao = new FiisDAO();
        List<Fiis> resultados = dao.buscarFiis();
        List<Fiis> fiis = new ArrayList<>();
        for (Fiis fiisSimulados : resultados) {
            double saldoDividendos = 0,
                    dividendoPorCota = fiisSimulados.getDividendYield(),
                    valorAporte = calculadoraV.getAporte(),
                    precoCota = fiisSimulados.getPrecoFiis(),
                    dvCotas = fiisSimulados.getDesvioCotas(),
                    dvDiv = fiisSimulados.getDesvioDividendos();
            int meses = calculadoraV.getMeses(),
                    quantidadeCotas = calculadoraV.getQtdCotas(),
                    reinvestir = calculadoraV.getReinvestir();

            for (int i = 1; i <= meses; i++) {
                double dividendosRecebidos = quantidadeCotas * dividendoPorCota;
                saldoDividendos += dividendosRecebidos + valorAporte;

                if (reinvestir == 1) {
                    int novasCotas = (int) (saldoDividendos / precoCota);
                    quantidadeCotas += novasCotas;
                    saldoDividendos -= novasCotas * precoCota;
                } else {
                    int novasCotasAporte = (int) (valorAporte / precoCota);
                    quantidadeCotas += novasCotasAporte;
                    saldoDividendos -= novasCotasAporte * precoCota;
                }



            }

            //criar no model os atributos abaixo

            double saldoCotas = quantidadeCotas*precoCota;
            double saldoCotasReal = saldoCotas - saldoCotas * dvCotas;
            double saldoDivReal = saldoDividendos - saldoDividendos * dvDiv;

            fiisSimulados.setSaldoCotas(saldoCotasReal);
            fiisSimulados.setSaldoDividendos(saldoDivReal);

            fiis.add(fiisSimulados);
        }
        return fiis;
    }
}
/*
    public Acoes simularAcao(Acoes calculadoraV) {
        AcoesDao dao = new AcoesDao();
        Acoes resultados = dao.buscarAcoes(new Acoes());
        double precoCompra = calculadoraV.getPrecoAcao(), precoVenda = calculadoraV.getPrecoVenda();
        int quantidade = calculadoraV.getQtdAcoes();

        double custoTotal = precoCompra * quantidade;
        double valorVenda = precoVenda * quantidade;
        double saldo = valorVenda - custoTotal;

        return null;
    }
}


 */