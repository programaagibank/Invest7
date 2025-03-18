    package com.invest7.model;

    import java.util.Date;

    public class UserModel {
        private String nome = null, cpf = null, endereco = null, genero = null, email = null, senha = null, senhaHash = null;
        String dt_nasc;
        int id_user;

        public UserModel(int id_user, String nome, String cpf, String endereco, String email, String senhaHash, String genero, String dt_nasc) {
            this.id_user = id_user;
            this.nome = nome;
            this.cpf = cpf;
            this.endereco = endereco;
            this.email = email;
            this.senhaHash = senhaHash;
            this.dt_nasc = dt_nasc;
            this.genero = genero;
        }

        public UserModel(int id_user, String nome, String genero, String endereco, String dt_nasc) {
            this.id_user = id_user;
            this.nome = nome;
            this.genero = genero;
            this.endereco = endereco;
            this.dt_nasc = dt_nasc;
        }

        public UserModel(String nome, String cpf, String endereco, String email, String senhaHash, String genero, String dt_nasc) {
            this.nome = nome;
            this.cpf = cpf;
            this.endereco = endereco;
            this.email = email;
            this.senhaHash = senhaHash;
            this.dt_nasc = dt_nasc;
            this.genero = genero;
        }

        public UserModel(String nome, String email, String cpf, String genero, String endereco, String dt_nasc) {
            this.nome = nome;
            this.email = email;
            this.cpf = cpf;
            this.genero = genero;
            this.endereco = endereco;
            this.dt_nasc = dt_nasc;
        }

        public UserModel(String email) {
            this.email = email;
        }

        public UserModel(int id_user) {
            this.id_user = id_user;
        }

        public UserModel(int id_user, String email, String senha) {
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

        public UserModel(String nome, String senha) {
            this.nome = nome;
            this.senha = senha;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getDt_nasc() {
            return dt_nasc;
        }

        public void setDt_nasc(String dt_nasc) {
            this.dt_nasc = dt_nasc;
        }

        public String getSenhaHash() {
            return senhaHash;
        }

        public void setSenhaHash(String senhaHash) {
            this.senhaHash = senhaHash;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }

        public String getGenero() {
            return genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }
    }
