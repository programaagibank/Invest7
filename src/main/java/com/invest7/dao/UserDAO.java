package com.invest7.dao;

import com.invest7.model.UserModel;
import com.invest7.util.ConnectionFactory;

import java.sql.*;

public class UserDAO {

    public UserModel createUser(UserModel userC) {
        String sql = "INSERT INTO usuarios (nome, email, senha, data_nascimento, genero, endereco, cpf) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?); ";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, userC.getNome());
            stmt.setString(2, userC.getEmail());
            stmt.setString(3, userC.getSenhaHash());
            stmt.setString(4, userC.getDt_nasc());
            stmt.setString(5, userC.getGenero());
            stmt.setString(6, userC.getEndereco());
            stmt.setString(7, userC.getCpf());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1); // Obtém o ID gerado
                        userC.setId_user(id); // Define o ID no objeto UserModel
                        return userC; // Retorna o UserModel com o ID

                    }
                }
            }
            return null;
        } catch (SQLException e) {
            System.err.println("Erro SQL: " + e.getMessage());
            e.printStackTrace();
            return null;
        }

    }
    public boolean deletarBanco(UserModel userD){
        String sql = "DELETE FROM usuarios WHERE email = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, userD.getEmail());
            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas >0 ;

        } catch (SQLException e) {  // Captura apenas SQLException
            System.err.println("Erro ao exluir usuarios: " + e.getMessage());
            return false;
        }
    }


    public UserModel findUserByEmail(UserModel userL) {
        String sql = "SELECT id_user, email, senha FROM usuarios WHERE email = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, userL.getEmail());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    userL = new UserModel(
                            rs.getInt("id_user"),
                            rs.getString("email"),
                            rs.getString("senha")
                    );
                }
            }
        } catch (SQLException e) {  // Captura apenas SQLException
            System.err.println("Erro ao buscar usuário: " + e.getMessage());
        }

        return userL;
    }

    public UserModel readUser(UserModel userR){
        UserModel user = null;
        String sql = "SELECT nome, email, data_nascimento, genero, endereco, cpf FROM usuarios WHERE id_user = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userR.getId_user());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = new UserModel(
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("cpf"),
                            rs.getString("genero"),
                            rs.getString("endereco"),
                            rs.getString("data_nascimento")


                    );
                }
            }
        } catch (SQLException e) {  // Captura apenas SQLException
            System.err.println("Erro ao buscar usuário: " + e.getMessage());
        }
        return user;
    }

    public UserModel atualizarUser(int id_user, String nome, String genero, String endereco, String dt_nasc){
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
                return new UserModel(id_user, nome, genero, endereco, dt_nasc);
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
