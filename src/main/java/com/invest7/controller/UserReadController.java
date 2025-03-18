package com.invest7.controller;

import com.invest7.dao.UserReadDAO;
import com.invest7.model.UserRead;

public class UserReadController {
        public UserRead  lerUser(){
            int userId = UserSession.getLoggedInUserId();
            UserReadDAO userDAO= new UserReadDAO();
            UserRead user = userDAO.readUser(userId);
            return user;



    }
}
