package com.invest7.dao;

import com.invest7.model.UserLogin;
import com.invest7.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDeleteDAO {

    public void deletarBanco(String email){
        String sql = "DELETE FROM usuarios WHERE email = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            int linhasAfetadas = stmt.executeUpdate();


        } catch (SQLException e) {  // Captura apenas SQLException
            System.err.println("Erro ao exluir usuarios: " + e.getMessage());

        }
    }
}
