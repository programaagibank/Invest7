package com.invest7.controller;

import com.invest7.dao.UserCreateDAO;
import com.invest7.dao.UserReadDAO;
import com.invest7.model.UserCreate;
import com.invest7.model.UserRead;

import java.util.Date;

public class UserReadController {
        public void lerUser(){
            int userId = UserSession.getLoggedInUserId();
            UserReadDAO userDAO= new UserReadDAO();
            UserRead user = userDAO.readUser(userId);

                if (user != null) {
                    System.out.println("Usuário encontrado:");
                    System.out.println("Nome: " + user.getNome());
                    System.out.println("Email: " + user.getEmail());
                    System.out.println("CPF: " + user.getCpf());
                    System.out.println("Gênero: " + user.getGenero());
                    System.out.println("Endereço: " + user.getEndereco());
                    System.out.println("Data de Nascimento: " + user.getDt_nasc());
                } else {
                    System.out.println("Usuário não encontrado.");
                }


    }
}
