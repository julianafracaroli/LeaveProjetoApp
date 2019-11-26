package com.example.aluno.leaveprojeto.models;

import com.orm.SugarRecord;

/**
 * Created by aluno on 26/11/19.
 */

public class Roupa extends SugarRecord {
    private String etTipoRoupa;
    private String etTamRoupa;

    public Roupa(){

    }



    public String getEtTipoRoupa() {
        return etTipoRoupa;
    }

    public void setEtTipoRoupa(String etTipoRoupa) {
        this.etTipoRoupa = etTipoRoupa;
    }

    public String getEtTamRoupa() {
        return etTamRoupa;
    }

    public void setEtTamRoupa(String etTamRoupa) {
        this.etTamRoupa = etTamRoupa;
    }
}
