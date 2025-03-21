package com.invest7.dao;
import com.invest7.model.produtos.Acoes;
import com.invest7.util.ConnectionFactory;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class AcoesDao {
    public List<Acoes> buscarAcoes() {
        List<Acoes> acoesAll = new ArrayList<>();
        String sql = "SELECT nome_prod, tx_ir, preco_acao, desvio FROM acoes";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {


            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Acoes acoes = new Acoes(
                            rs.getString("nome_prod"),
                            rs.getDouble("tx_ir"),
                            rs.getDouble("preco_acoes"),
                            rs.getDouble("desvio")
                    );


                    acoesAll.add(acoes);
                }
            }
        } catch (SQLException e) {  // Captura apenas SQLException
            System.err.println("Erro ao buscar usuário: " + e.getMessage());
            return null;
        }
        return acoesAll;
    }
}
