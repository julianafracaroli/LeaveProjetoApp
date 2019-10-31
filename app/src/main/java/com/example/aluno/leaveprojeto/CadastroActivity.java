package com.example.aluno.leaveprojeto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aluno.leaveprojeto.models.User;
import com.orm.SugarContext;



public class CadastroActivity extends AppCompatActivity {
    private Button bCadastrar;
    private EditText etNome, etEmail, etSenha, etSobrenome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        bCadastrar = findViewById(R.id.bCadastrar);
        etNome = findViewById(R.id.etNome);
        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);
        etSobrenome = findViewById(R.id.etSobrenome);
        bCadastrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            String nome = etNome.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String senha = etSenha.getText().toString().trim();
            String sobrenome = etSobrenome.getText().toString().trim();

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || sobrenome.isEmpty()) {
                Toast.makeText(CadastroActivity.this, "Preencha todos os campos.",
                        Toast.LENGTH_SHORT).show();
            } else{
                User user = new User(nome, senha, email, sobrenome);

                try {
                    SugarContext.init(CadastroActivity.this);
                    user.save();
                    SugarContext.terminate();
                    Toast.makeText(CadastroActivity.this, "Salvo com sucesso.", Toast.LENGTH_SHORT).show();
                    limparCampo();
                    finish();
                }
                catch (Exception e) {

                }
            }


            }
        });

    }

    private void  limparCampo() {
        etNome.setText("");
        etSobrenome.setText("");
        etSenha.setText("");
        etEmail.setText("");
    }


}
