package com.invest7.dao;

import com.invest7.model.UserLogin;
import com.invest7.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginDAO {
    public UserLogin findUserByEmail(String email) {
        UserLogin user = null;
        String sql = "SELECT email, senha FROM usuarios WHERE email = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = new UserLogin(
                            rs.getString("email"),
                            rs.getString("senha")
                    );
                }
            }
        } catch (SQLException e) {  // Captura apenas SQLException
            System.err.println("Erro ao buscar usuário: " + e.getMessage());
        }

        return user;
    }
}

