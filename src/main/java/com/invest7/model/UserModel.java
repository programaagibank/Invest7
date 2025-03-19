    package com.invest7.model;

    import java.util.Date;

    public class UserModel {
        private String nome = null, cpf = null, endereco = null, genero = null, email = null, senha = null, senhaHash = null, dt_nasc = null, descricao_perfil = null;
        int id_user, id_perfil;

        //model para update
        public UserModel(String nome,String endereco, String email, String genero, String dt_nasc) {
            this.nome = nome;
            this.endereco = endereco;
            this.dt_nasc = dt_nasc;
            this.genero = genero;
        }

        //model para criar usuario
        public UserModel(String nome, String cpf, String endereco, String email, String senhaHash, String genero, String dt_nasc, int id_perfil) {
            this.nome = nome;
            this.cpf = cpf;
            this.endereco = endereco;
            this.email = email;
            this.senhaHash = senhaHash;
            this.dt_nasc = dt_nasc;
            this.genero = genero;
            this.id_perfil = id_perfil;
        }
        public UserModel(int id_user, String nome, String genero, String endereco, String dt_nasc) {
            this.id_user = id_user;
            this.nome = nome;
            this.genero = genero;
            this.endereco = endereco;
            this.dt_nasc = dt_nasc;
        }

        // model de retorno para ler usuario
        public UserModel(String nome, String email, String cpf, String genero, String endereco, String dt_nasc, String descricao_perfil) {
            this.nome = nome;
            this.email = email;
            this.cpf = cpf;
            this.genero = genero;
            this.endereco = endereco;
            this.dt_nasc = dt_nasc;
            this.descricao_perfil = descricao_perfil;
        }

        // model para chamar o Ler Usuario
        public UserModel(int id_user) {
            this.id_user = id_user;
        }

        //serve para quando o usuario refaz o questinario
        public UserModel(int id_user, int id_perfil) {
            this.id_user = id_user;
            this.id_perfil = id_perfil;
        }

        // model de login
        public UserModel(int id_user, String email, String senha) {
            this.id_user = id_user;
            this.email = email;
            this.senha = senha;
        }


        public UserModel(String nome, String senha) {
            this.nome = nome;
            this.senha = senha;
        }

        public UserModel(String nome, String endereco, String genero, String dataNasc) {
            this.nome = nome;
            this.endereco = endereco;
            this.genero = genero;
            this.dt_nasc = dt_nasc;
        }


        public int getId_perfil() {return id_perfil;}
        public void setId_perfil(int id_perfil) {this.id_perfil = id_perfil;}

        public UserModel(String email) {
            this.email = email;
        }


        public int getId_user() {
            return id_user;
        }

        public void setId_user(int id_user) {
            this.id_user = id_user;
        }


        public String getDescricao_perfil() {return descricao_perfil;}

        public void setDescricao_perfil(String descricao_perfil) {this.descricao_perfil = descricao_perfil;}

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
