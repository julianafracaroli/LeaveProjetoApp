package com.example.aluno.leaveprojeto.models;

import com.orm.SugarRecord;

/**
 * Created by aluno on 12/08/19.
 */

public class User extends SugarRecord{
    private String usuario;
    private String senha;
    private String email;

    public User(){

    }

    public User(String usuario, String senha, String email) {
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
    }
}
