package com.invest7.dao;

import com.invest7.model.UserCreate;
import com.invest7.model.UserRead;
import com.invest7.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserReadDAO {
    public UserRead readUser(int userId){
        UserRead user = null;
        String sql = "SELECT nome, email, data_nascimento, genero, endereco, cpf FROM usuarios WHERE id_user = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = new UserRead(
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("cpf"),
                            rs.getString("genero"),
                            rs.getString("endereco"),
                            rs.getDate("data_nascimento")


                    );
                }
            }
        } catch (SQLException e) {  // Captura apenas SQLException
            System.err.println("Erro ao buscar usuário: " + e.getMessage());
        }
        return user;
    }
}
