package com.invest7.dao;
import com.invest7.model.Fiis;

public class FiisDAO {

        public Fiis buscarFiis(Fiis fiis) {
            String sql = "SELECT nome, taxa, valor_cota FROM fiis WHERE id = ?";

        }

}
