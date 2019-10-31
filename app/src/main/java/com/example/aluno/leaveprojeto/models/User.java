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

    public User(String nome, String senha, String email, String sobrenome) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.sobrenome = sobrenome;
    }
}
