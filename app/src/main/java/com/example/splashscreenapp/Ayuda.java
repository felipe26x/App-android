package com.example.splashscreenapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;

public class Ayuda extends AppCompatActivity {

    CardView imagen,imagen2;

    float v = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        imagen = findViewById(R.id.imagen);
        imagen2 = findViewById(R.id.imagen2);





        imagen.setTranslationX(800);
        imagen2.setTranslationX(800);








        imagen.setAlpha(v);
        imagen.setAlpha(v);











        imagen.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        imagen2.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();



    }




}