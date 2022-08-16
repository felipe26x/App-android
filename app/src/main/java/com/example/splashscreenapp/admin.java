package com.example.splashscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

    }

    public void back (View view){
        Intent intent = new Intent(admin. this, MainActivity.class);
        startActivity(intent);

    }


    public void usuario_a (View view){
        Intent intent = new Intent(admin. this, MainActivity2.class);
        startActivity(intent);

    }



    public void productos_a (View view){
        Intent intent = new Intent(admin. this, MainActivity3.class);
        startActivity(intent);

    }

}