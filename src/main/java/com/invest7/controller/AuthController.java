package com.invest7.controller;

import com.invest7.dao.UserLoginDAO;
import com.invest7.model.UserLogin;
import at.favre.lib.crypto.bcrypt.BCrypt;
import com.invest7.util.JwtUTIL;
import com.invest7.view.MenuInicial;


public class AuthController {

    public String login(String email, String senha) {
        UserLoginDAO userDAO = new UserLoginDAO();
        UserLogin userLogin = userDAO.findUserByEmail(email);
        String token = null;

        if (userLogin == null) {
            return null;
        }

        if (BCrypt.verifyer().verify(senha.toCharArray(), userLogin.getSenha()).verified) {
            token = JwtUTIL.generateToken(email);

            // Armazena o ID do usuário na sessão
            UserSession.setLoggedInUserId(userLogin.getId_user());
            return token;
        } else {
            return null;
        }
    }

    public void logout() {
        // Limpa a sessão do usuário
        UserSession.clear();

        MenuInicial menuInicial = new MenuInicial();
        menuInicial.exibirMenuInicial();
    }
}
