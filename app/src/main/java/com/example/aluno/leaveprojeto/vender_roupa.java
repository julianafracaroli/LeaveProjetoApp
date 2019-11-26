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


public class vender_roupa extends AppCompatActivity {
    private Button cam;
    private EditText etTipoRoupa;
    private EditText etTamRoupa;
    private Button btSalvar;
    private ImageView imgCamera;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_vender_roupa);
        imgCamera = findViewById(R.id.imgCamera);
        cam = findViewById(R.id.cam);
        btSalvar = findViewById(R.id.btSalvar);
        etTamRoupa = findViewById(R.id.etTamRoupa);
        etTipoRoupa = findViewById(R.id.etTipoRoupa);

        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tirarFoto();
            }

        });
        //return imgCamera();
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
}
