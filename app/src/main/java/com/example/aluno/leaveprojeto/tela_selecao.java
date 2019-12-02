package com.example.aluno.leaveprojeto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.aluno.leaveprojeto.models.User;
import com.orm.SugarContext;
import com.orm.query.Condition;
import com.orm.query.Select;

public class tela_selecao extends AppCompatActivity {
    private Button btVender;
    private Button btComprar;
    private Button btVEnder;
    private Button excluirUser;
    private Button alterarUser;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_selecao);

        SugarContext.init(tela_selecao.this);
        long id = getIntent().getExtras().getLong("id");
        user = (Select.from(User.class).where(Condition.prop("id").eq(id)).list()).get(0);
        SugarContext.terminate();

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

        excluirUser = findViewById(R.id.excluirUser);
        excluirUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(tela_selecao.this,LoginActivity.class));
                SugarContext.init(tela_selecao.this);
                user.delete();
                SugarContext.terminate();
                Toast.makeText(tela_selecao.this,"Excluido com sucesso!", Toast.LENGTH_LONG).show();
        }
        });
    }


}
