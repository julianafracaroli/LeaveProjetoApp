package com.example.aluno.leaveprojeto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tela_selecao extends AppCompatActivity {
    private Button btVender;
    private Button btComprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        btComprar = findViewById(R.id.btComprar);

        btComprar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(tela_selecao.this,LoginActivity.class));
            }
        });

    }
}
