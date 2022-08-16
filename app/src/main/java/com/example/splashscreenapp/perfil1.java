package com.example.splashscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class perfil1 extends AppCompatActivity {


    private Button Actualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil1);
        Actualizar=(Button)findViewById(R.id.ventana2);

        Actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });

    }

    public void onClick(View view) {
        Intent intent = new Intent(perfil1.this, MainActivity.class);
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