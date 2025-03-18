package com.invest7.controller;

import com.invest7.dao.UserUpdateDAO;
import com.invest7.model.UserUpdate;

public class UserUpdateController {
    public boolean uptadeUser(String nome, String genero, String endereco, String dt_nasc){
        UserUpdateDAO userDao =  new UserUpdateDAO();
        int id_user = UserSession.getLoggedInUserId();
        UserUpdate userUp = userDao.atualizarUser(id_user, nome, genero, endereco, dt_nasc);

        if (userUp != null){ return true;}
        else {return false;}


    }
}
