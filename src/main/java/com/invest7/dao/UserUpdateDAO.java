package com.invest7.dao;

import com.invest7.model.UserUpdate;
import com.invest7.util.ConnectionFactory;

import java.sql.*;

public class UserUpdateDAO {
        public UserUpdate atualizarUser(int id_user, String nome, String genero, String endereco, String dt_nasc){
            String sql = "UPDATE usuarios SET nome = ?, genero = ?, endereco = ?, data_nascimento = ? WHERE id_user = ?";
            try (Connection conn = ConnectionFactory.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, nome);
                stmt.setString(2, genero);
                stmt.setString(3, endereco);
                stmt.setString(4, dt_nasc);
                stmt.setInt(5, id_user);
                int linhasAfetadas = stmt.executeUpdate();

                if (linhasAfetadas > 0) {
                    return new UserUpdate(id_user, nome, genero, endereco, dt_nasc);
                } else {
                    return null;
                }
            } catch (SQLException e) {
                System.err.println("Erro SQL: " + e.getMessage());
                e.printStackTrace();
                return null;
            }
        }

}
