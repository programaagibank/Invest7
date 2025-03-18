package com.invest7.dao;

import com.invest7.model.UserCreate;
import com.invest7.model.UserLogin;
import com.invest7.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.sql.Statement;

public class UserCreateDAO {

    public int createUser(String nome, String email, String senha, String cpf, String endereco, String genero, String dt_nasc) {
        String sql = "INSERT INTO usuarios (nome, email, senha, data_nascimento, genero, endereco, cpf) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?); ";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, senha);
            stmt.setString(4, dt_nasc);
            stmt.setString(5, genero);
            stmt.setString(6, endereco);
            stmt.setString(7, cpf);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1); // Retorna o ID gerado
                    }
                }
            }
            return -1;
        } catch (SQLException e) {
            System.err.println("Erro SQL: " + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }
}
