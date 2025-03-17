package com.invest7.model;

public class UserLogin {
    private int id_user;
    private String email;
    private  String senha;

    public UserLogin(int id_user, String email, String senha) {
        this.id_user = id_user;
        this.email = email;
        this.senha = senha;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
