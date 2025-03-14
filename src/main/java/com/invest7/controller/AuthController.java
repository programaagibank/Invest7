package com.invest7.controller;

import com.invest7.dao.UserLoginDAO;
import com.invest7.model.UserLogin;
import at.favre.lib.crypto.bcrypt.BCrypt;
public class AuthController {

    public boolean login(String email, String senha) {
        UserLoginDAO userDAO = new UserLoginDAO();
        UserLogin userLogin = userDAO.findUserByEmail(email);

        if (userLogin == null) {
            return false;
        }

        if (BCrypt.verifyer().verify(senha.toCharArray(), userLogin.getSenha()).verified) {
            return true;
        } else {
            return false;
        }
    }
}
