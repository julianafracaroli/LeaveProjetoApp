package com.example.aluno.leaveprojeto.models;

import com.orm.SugarRecord;

/**
 * Created by aluno on 12/08/19.
 */

public class User extends SugarRecord{
    private String nome;
    private String senha;
    private String email;
    private String sobrenome;

    public User(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {

        return senha;
    }

    public void setSenha(String senha) {

        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public User(String nome, String senha, String email, String sobrenome) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.sobrenome = sobrenome;
    }
}
