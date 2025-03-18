package com.invest7.dao;
import com.invest7.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class VerificaSeExisteDAO {

    public boolean verificaEmail(String email){
        String sql = "SELECT 1 FROM usuarios WHERE email = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                    return rs.next();
            }
        } catch (SQLException e) {
            System.err.println("Email já existe " + e.getMessage());
            return false;
        }


    }

    public boolean verificaCPF(String cpf){
        String sql = "SELECT 1 FROM usuarios WHERE cpf = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao verificar CPF: " + e.getMessage());
            return false;
        }
    }
}
