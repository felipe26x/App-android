package com.example.splashscreenapp.Productos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


import com.example.splashscreenapp.MainActivity3;
import com.example.splashscreenapp.R;

public class detalles_p extends AppCompatActivity {

    TextView tvid,tvname,tvprice,tvinfop,tvdescription;
    int position;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_producto);


        //Initializing Views
        tvid = findViewById(R.id.txtid);
        tvname = findViewById(R.id.txtname);
        tvprice = findViewById(R.id.txtlastnames);
        tvinfop = findViewById(R.id.txtemail);
        tvdescription = findViewById(R.id.txtnumber);


        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        tvid.setText("ID: " + MainActivity3.productArrayList.get(position).getId());
        tvname.setText("Name: " + MainActivity3.productArrayList.get(position).getNombre());
        tvprice.setText("price: " + MainActivity3.productArrayList.get(position).getPrecio());
        tvinfop.setText("Informacion: " + MainActivity3.productArrayList.get(position).getInformacion_de_produccion());
        tvdescription.setText("Descripcion: " + MainActivity3.productArrayList.get(position).getDescripcion());

    }
}