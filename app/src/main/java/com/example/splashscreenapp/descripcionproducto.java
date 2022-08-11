package com.example.splashscreenapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class descripcionproducto extends AppCompatActivity {



        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcionproducto);






    }


    public void home(View view) {
        Intent intent= new Intent(descripcionproducto.this,MainActivity.class);
        startActivity(intent);
    }

    public void subir(View view) {
        Intent intent= new Intent(descripcionproducto.this,Sproducto.class);
        startActivity(intent);
    }

    public void fav(View view) {
        Intent intent= new Intent(descripcionproducto.this,Favoritos.class);
        startActivity(intent);


    }

    public void perfil3(View view) {
        Intent intent= new Intent(descripcionproducto.this,perfil1.class);
        startActivity(intent);
    }

    public void volver(View view) {
        Intent intent= new Intent(descripcionproducto.this,MainActivity.class);
        startActivity(intent);
    }

    public void onClickLlamada(View view) {
        // Intent i = new Intent(android.content.Intent.ACTION_CALL,
        // Uri.parse("tel:+573168646125"));
        Intent i = new Intent(android.content.Intent.ACTION_DIAL,
                Uri.parse("tel:+573168646125")); //
        startActivity(i);
    }


}