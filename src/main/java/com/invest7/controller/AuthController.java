package com.invest7.controller;

import com.invest7.dao.UserLoginDAO;
import com.invest7.model.UserLogin;

public class AuthController {

    public boolean login(String email, String senha) {
        UserLoginDAO userDAO = new UserLoginDAO();
        UserLogin userLogin = userDAO.findUserByEmail(email);

        if (userLogin == null) {
            return false;
        }

        if (userLogin.getSenha().equals(senha)) {
            return true;
        } else {
            return false;
        }
    }
}
