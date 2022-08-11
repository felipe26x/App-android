package com.example.splashscreenapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class Sproducto extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView Image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sproducto);

        Image = findViewById(R.id.etimage);
    }

    public void home(View view) {

        Intent intent= new Intent(Sproducto.this,MainActivity.class);
        startActivity(intent);
    }


    public void fav(View view) {

        Intent intent= new Intent(Sproducto.this,Favoritos.class);
        startActivity(intent);
    }

    public void perfil3(View view) {
        Intent intent= new Intent(Sproducto.this,perfil1.class);
        startActivity(intent);
    }





    public void onClick(View view) {
    }


    public void dispatchTakePictureIntent(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    public void volver(View view) {
        Intent intent= new Intent(Sproducto.this,MainActivity.class);
        startActivity(intent);
    }

    public void subir(View view) {
    }

    public void cargar(View view) {
         cargarImagen();

    }

    private void cargarImagen() {
        Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent,"selecciona la aplicacion"),10);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode ==RESULT_OK){
            Uri path =data.getData();
            Image.setImageURI(path);
        }
    }
}