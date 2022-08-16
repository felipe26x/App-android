package com.example.splashscreenapp.usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.splashscreenapp.MainActivity2;
import com.example.splashscreenapp.R;

public class detalles extends AppCompatActivity {

    TextView tvid,tvname,tvlastnames,tvnameuser,tvemail,tvnumber;
    int position;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);


        //Initializing Views
        tvid = findViewById(R.id.txtid);
        tvname = findViewById(R.id.txtname);
        tvlastnames = findViewById(R.id.txtlastnames);
        tvnameuser = findViewById(R.id.txtnameuser);
        tvemail = findViewById(R.id.txtemail);
        tvnumber = findViewById(R.id.txtnumber);


        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        tvid.setText("ID: " + MainActivity2.employeeArrayList.get(position).getId());
        tvname.setText("Names: " + MainActivity2.employeeArrayList.get(position).getNombres());
        tvlastnames.setText("lastnames: " + MainActivity2.employeeArrayList.get(position).getApellidos());
        tvnameuser.setText("lastnames: " + MainActivity2.employeeArrayList.get(position).getNombreusuario());
        tvemail.setText("Email: " + MainActivity2.employeeArrayList.get(position).getEmail());
        tvnumber.setText("Number: " + MainActivity2.employeeArrayList.get(position).getNumero_telefono());

    }
}