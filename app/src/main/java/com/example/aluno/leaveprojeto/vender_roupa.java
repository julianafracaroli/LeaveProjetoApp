package com.example.aluno.leaveprojeto;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.aluno.leaveprojeto.models.Roupa;
import com.orm.SugarContext;


public class vender_roupa extends AppCompatActivity {
    private Button cam;
    private EditText etTipoRoupa;
    private EditText etTamRoupa;
    private Button btSalvar;
    private ImageView imgCamera;
    private Button btListar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_vender_roupa);
        imgCamera = findViewById(R.id.imgCamera);
        cam = findViewById(R.id.cam);
        btSalvar = findViewById(R.id.btSalvar);
        etTamRoupa = findViewById(R.id.etTamRoupa);
        etTipoRoupa = findViewById(R.id.etTipoRoupa);
        btListar = findViewById(R.id.btListar);
        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tirarFoto();
            }

        });

        btSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String tamRoupa = etTamRoupa.getText().toString().trim();
                String tipoRoupa = etTipoRoupa.getText().toString().trim();

                if (tamRoupa.isEmpty() || tipoRoupa.isEmpty()){
                    Toast.makeText(vender_roupa.this, "Preencha todos os campos.",
                            Toast.LENGTH_SHORT).show();
                }else {
                    Roupa roupa = new Roupa(tamRoupa, tipoRoupa);

                    try {
                        SugarContext.init(vender_roupa.this);
                        roupa.save();
                        SugarContext.terminate();
                        Toast.makeText(vender_roupa.this, "Salvo com sucesso.", Toast.LENGTH_SHORT).show();
                        limparCampo();
                        finish();
                    }
                    catch (Exception e) {
                        System.out.println("<========================================>");
                        e.printStackTrace();
                        System.out.println("<========================================>");
                    }
                }

            }
        });

        btListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(vender_roupa.this, listaActivity.class));
            }
        });
    }
private void tirarFoto(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,1);

}
@Override
    public void onActivityResult (int requestCode,int resultCode, Intent data){

    if (requestCode==1){
        Bundle extra = data.getExtras();
        Bitmap imagem = (Bitmap) extra.get("data");
        imgCamera.setImageBitmap(imagem);
    }
    super.onActivityResult(requestCode, resultCode, data);
}

    private void  limparCampo() {
        etTamRoupa.setText("");
        etTipoRoupa.setText("");
    }
}
