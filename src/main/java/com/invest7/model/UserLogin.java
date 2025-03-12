package com.invest7.model;

public class UserLogin {
    private String email;
    private  String senha;

    public UserLogin(String email, String senha) {
        this.email = email;
        this.senha = senha;
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
