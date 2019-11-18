package com.example.aluno.leaveprojeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


public class vender_roupa extends AppCompatActivity {
    private Button cam;
    private EditText etTipoRoupa;
    private EditText etTamRoupa;
    private Button btSalvar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vender_roupa);

        cam = findViewById(R.id.cam);
        btSalvar = findViewById(R.id.btSalvar);
        etTamRoupa = findViewById(R.id.etTamRoupa);
        etTipoRoupa = findViewById(R.id.etTipoRoupa);



    }
}
