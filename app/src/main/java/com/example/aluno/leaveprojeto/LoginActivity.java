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
                System.out.println(nome);
                String senha = etSenha.getText().toString().trim();
                if (nome.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Preencha todos os campos.",
                            Toast.LENGTH_SHORT).show();

                } else {
                    try {
                        SugarContext.init(LoginActivity.this);
                        User user = (Select.from(User.class).where(Condition.prop("nome").eq(nome)).and(Condition.prop("senha").eq(senha)).list()).get(0);
                        Toast.makeText(LoginActivity.this, "Logado com Sucesso", Toast.LENGTH_SHORT).show();
                        SugarContext.terminate();
                        Intent intent = new Intent(LoginActivity.this,tela_selecao.class);
                        Bundle b = new Bundle();
                        b.putLong("id", user.getId());
                        intent.putExtras(b);

                        startActivity(intent);
                    } catch (Exception e){
                        System.err.println("<====================================>");
                        e.printStackTrace();
                        System.err.println("<====================================>");
                        Toast.makeText(LoginActivity.this, "Login ou senha incorretos", Toast.LENGTH_SHORT).show();

                    }
                }


            }
        });


    }
}
