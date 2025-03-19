package com.invest7.dao;
import com.invest7.model.Acoes;


public class AcoesDao {
    public Acoes buscarAcoes(Acoes acoes) {
        String sql = "SELECT nome, taxa, valor_cota FROM acoes WHERE id = ?";
        return null;
    }
}
