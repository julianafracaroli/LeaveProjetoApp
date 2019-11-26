package com.example.aluno.leaveprojeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.aluno.leaveprojeto.models.Roupa;
import com.orm.SugarContext;
import com.orm.query.Select;

import java.util.List;

public class listaActivity extends AppCompatActivity {
    private List<Roupa> roupas;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listView = findViewById(R.id.listView);

        SugarContext.init(listaActivity.this);
        roupas = Select.from(Roupa.class).list();
        SugarContext.terminate();

        String listaRoupa[] = new String[roupas.size()];

        for (int cont = 0; cont < roupas.size();cont++){
               listaRoupa[cont] = roupas.get(cont).getEtTamRoupa() + " - " + roupas.get(cont).getEtTipoRoupa();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(listaActivity.this,android.R.layout.simple_list_item_1, listaRoupa);
        listView.setAdapter(adapter);
    }

}
