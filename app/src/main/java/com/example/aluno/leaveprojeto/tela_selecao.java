package com.example.aluno.leaveprojeto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tela_selecao extends AppCompatActivity {
    private Button btVender;
    private Button btComprar;
    private Button btVEnder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_selecao);

        btComprar = findViewById(R.id.btComprar);

        btComprar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(tela_selecao.this,LoginActivity.class));
            }
        });
        btVender = findViewById(R.id.btVender);
        btVender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(tela_selecao.this,vender_roupa.class));

            }
        });



    }
}
