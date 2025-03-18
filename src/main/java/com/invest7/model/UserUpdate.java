package com.invest7.model;

import java.util.Date;

public class UserUpdate {
    private String nome = null, endereco = null, genero = null;
    String dt_nasc;
    int id_user;

    public UserUpdate(int id_user, String nome, String endereco, String genero, String dt_nasc) {
        this.id_user = id_user;
        this.nome = nome;
        this.endereco = endereco;
        this.genero = genero;
        this.dt_nasc = dt_nasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDt_nasc() {
        return dt_nasc;
    }

    public void setDt_nasc(String dt_nasc) {
        this.dt_nasc = dt_nasc;
    }
}
