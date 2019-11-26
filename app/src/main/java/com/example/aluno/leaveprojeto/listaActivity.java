package com.example.aluno.leaveprojeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.aluno.leaveprojeto.models.Roupa;
import com.orm.query.Select;

import java.util.List;

public class listaActivity extends AppCompatActivity {
    private List<Roupa> roupas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        roupas = Select.from(Roupa.class).list();

        String listaRoupa[] = new String[roupas.size()];

        for (int cont = 0; cont < roupas.size();cont++){
               listaRoupa[cont] = roupas.get(cont).getEtTamRoupa() + " - " + roupas.get(cont).getEtTipoRoupa();
        }
    }

}