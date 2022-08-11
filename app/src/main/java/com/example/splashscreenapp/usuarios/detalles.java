package com.example.splashscreenapp.usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.splashscreenapp.MainActivity2;
import com.example.splashscreenapp.R;

public class detalles extends AppCompatActivity {

    TextView tvid,tvname,tvlastnames,tvemail,tvnumber;
    int position;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);


        //Initializing Views
        tvid = findViewById(R.id.txtid);
        tvname = findViewById(R.id.txtname);
        tvlastnames = findViewById(R.id.txtprice);
        tvemail = findViewById(R.id.txtinfop);
        tvnumber = findViewById(R.id.txtdescription);


        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        tvid.setText("ID: " + MainActivity2.employeeArrayList.get(position).getId());
        tvname.setText("Names: " + MainActivity2.employeeArrayList.get(position).getNombres());
        tvemail.setText("lastnames: " + MainActivity2.employeeArrayList.get(position).getApellidos());
        tvemail.setText("Email: " + MainActivity2.employeeArrayList.get(position).getEmail());
        tvnumber.setText("Contact: " + MainActivity2.employeeArrayList.get(position).getEmail());

    }
}