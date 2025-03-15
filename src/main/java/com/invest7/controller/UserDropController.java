package com.invest7.controller;

import com.invest7.dao.UserDeleteDAO;

public class UserDropController {

    public boolean deletarConta(String email, String senha){
        boolean exite = false;
        UserDeleteDAO user = new UserDeleteDAO();
        UserCreateController userCreate = new UserCreateController();
        exite = userCreate.verificaEmail(email);
        if (exite) {
            user.deletarBanco(email);
            return true;
        } else {
            return false;
        }
    }
}
