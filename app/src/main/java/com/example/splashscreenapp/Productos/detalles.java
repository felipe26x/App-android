package com.example.splashscreenapp.Productos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.splashscreenapp.MainActivity2;
import com.example.splashscreenapp.R;

public class detalles extends AppCompatActivity {

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
        tvprice = findViewById(R.id.txtprice);
        tvinfop = findViewById(R.id.txtinfop);
        tvdescription = findViewById(R.id.txtdescription);


        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        tvid.setText("ID: " + MainActivity2.employeeArrayList.get(position).getId());
        tvname.setText("Name: " + MainActivity2.employeeArrayList.get(position).getNombres());
        tvprice.setText("price: " + MainActivity2.employeeArrayList.get(position).getApellidos());
        tvinfop.setText("Email: " + MainActivity2.employeeArrayList.get(position).getEmail());
        tvdescription.setText("Contact: " + MainActivity2.employeeArrayList.get(position).getEmail());

    }
}