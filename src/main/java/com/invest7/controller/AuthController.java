package com.invest7.controller;

import com.invest7.dao.UserLoginDAO;
import com.invest7.model.UserLogin;

public class AuthController {

    public String login(String email, String senha) {
        UserLoginDAO userDAO = new UserLoginDAO();
        UserLogin userLogin = userDAO.findUserByEmail(email);

        if (userLogin == null) {
            return "Usuário não encontrado!";
        }

        if (userLogin.getSenha().equals(senha)) {
            return "Login bem-sucedido para " + userLogin.getEmail();
        } else {
            return "Senha incorreta!";
        }
    }
}
