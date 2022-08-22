package com.example.splashscreenapp.Productos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        tvname = findViewById(R.id.txtnombre_p);
        tvprice = findViewById(R.id.txtprecio_p);
        tvinfop = findViewById(R.id.txtinfop_p);
        tvdescription = findViewById(R.id.txtdescription_p);


        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        tvid.setText("ID: " + MainActivity3.productArrayList.get(position).getId());
        tvname.setText("" + MainActivity3.productArrayList.get(position).getNombre());
        tvprice.setText("$" + MainActivity3.productArrayList.get(position).getPrecio());
        tvinfop.setText("" + MainActivity3.productArrayList.get(position).getInformacion_de_produccion());
        tvdescription.setText("" + MainActivity3.productArrayList.get(position).getDescripcion());

    }


    public void volver(View view) {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
}