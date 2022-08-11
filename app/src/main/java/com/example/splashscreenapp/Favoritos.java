package com.example.splashscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Favoritos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
    }

    public void home(View view) {

        Intent intent= new Intent(Favoritos.this,MainActivity.class);
        startActivity(intent);
    }



    public void subir(View view) {
        Intent intent= new Intent(Favoritos.this,Sproducto.class);
        startActivity(intent);
    }

    public void perfil(View v){
        Intent intent = new Intent(Favoritos.this, perfil1.class);
        startActivity(intent);

    }


}