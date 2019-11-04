package com.example.aluno.leaveprojeto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aluno.leaveprojeto.models.User;
import com.orm.SugarContext;
import com.orm.query.Condition;
import com.orm.query.Select;

public class LoginActivity extends AppCompatActivity {

    private TextView tvCadastro;
    private Button btEntrar;
    private EditText etNome, etSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        tvCadastro = findViewById(R.id.tv_cadastro_login);
        btEntrar = findViewById(R.id.btEntrar);
        etNome = findViewById(R.id.etNome);
        etSenha = findViewById(R.id.etSenha);



        tvCadastro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, CadastroActivity.class));
            }
        });


        btEntrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String nome = etNome.getText().toString().trim();
                String senha = etSenha.getText().toString().trim();
                if (nome.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Preencha todos os campos.",
                            Toast.LENGTH_SHORT).show();

                } else {
                    try {
                        User user = (Select.from(User.class).where(Condition.prop("login").eq(nome)).and(Condition.prop("senha").eq(senha)).list()).get(0);
                        SugarContext.init(LoginActivity.this);
                        Toast.makeText(LoginActivity.this, "Logado com Sucesso", Toast.LENGTH_SHORT).show();
                        user = (User.find(User.class, "nome = ?", nome).get(0));
                        SugarContext.terminate();

                        if(!user.getSenha().equals(senha)){
                            Toast.makeText(LoginActivity.this, "Senha Incorreta", Toast.LENGTH_SHORT);
                        } else {
                            startActivity(new Intent(LoginActivity.this, tela_selecao.class));
                        }
                    } catch (Exception e){
                        System.err.println("<====================================>");
                        e.printStackTrace();
                        System.err.println("<====================================>");
                    }
                }


            }
        });


    }
}
