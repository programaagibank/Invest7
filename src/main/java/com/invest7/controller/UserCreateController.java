package com.invest7.controller;

import com.invest7.dao.UserCreateDAO;
import com.invest7.dao.VerificaSeExisteDAO;
import com.invest7.model.UserCreate;

import java.util.Date;

public class UserCreateController {
    public boolean verificaCPF(String cpf){
        VerificaSeExisteDAO cpfCliente = new VerificaSeExisteDAO();
        return cpfCliente.verificaCPF(cpf);
    }

    public boolean verificaEmail(String email){
        VerificaSeExisteDAO cpfCliente = new VerificaSeExisteDAO();
        return cpfCliente.verificaEmail(email);
    }

    public boolean criarUser(String nome, String email, String senha, String cpf, String endereco,String genero, String dt_nasc){
        UserCreateDAO userDAO = new UserCreateDAO();
        int userId = userDAO.createUser(nome, email, senha, cpf, endereco, genero, dt_nasc);

        if (userId > 0){
            UserSession.setLoggedInUserId(userId);
            return true;
        } else return false;

    }
}
