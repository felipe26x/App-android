package com.example.splashscreenapp.Productos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.splashscreenapp.MainActivity3;
import com.example.splashscreenapp.R;

import java.util.HashMap;
import java.util.Map;

public class agregar_p extends AppCompatActivity {

    EditText txtNombre, txtPrecio, txtInformacion_de_produccion, txtDescripcion;
    Button btn_insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_producto);

        txtNombre = findViewById(R.id.nombre_p);
        txtPrecio = findViewById(R.id.precio_p);
        txtInformacion_de_produccion = findViewById(R.id.info_p);
        txtDescripcion = findViewById(R.id.descripcion_p);



        btn_insert = findViewById(R.id.btnInsert);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insertData();
            }
        });
    }

    private void insertData() {

        final String nombre = txtNombre.getText().toString().trim();
        final String precio = txtPrecio.getText().toString().trim();
        final String informacion_de_produccion = txtInformacion_de_produccion.getText().toString().trim();
        final String descripcion = txtDescripcion.getText().toString().trim();




        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("cargando...");

        if(nombre.isEmpty()){
            Toast.makeText(this, "ingrese nombre", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(precio.isEmpty()){
            Toast.makeText(this, "Ingrese el precio del producto", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(informacion_de_produccion.isEmpty()){
            Toast.makeText(this, "Ingrese la informacion de produccion del producto ", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(descripcion.isEmpty()){
            Toast.makeText(this, "Ingrese una descripcion mas amplia del producto.", Toast.LENGTH_SHORT).show();
            return;
        }


        else{
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "http://10.0.2.2/proyecto/Productos_app/insertar_.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if(response.equalsIgnoreCase("datas insertados")){
                                Toast.makeText(agregar_p.this, "datas insertados", Toast.LENGTH_SHORT).show();



                                progressDialog.dismiss();
                                startActivity(new Intent(getApplicationContext(), MainActivity3.class));
                                finish();
                            }
                            else{
                                Toast.makeText(agregar_p.this, response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(agregar_p.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();

                    params.put("nombre",nombre);
                    params.put("precio",precio);
                    params.put("informacion_de_produccion",informacion_de_produccion);
                    params.put("descripcion",descripcion);






                    return params;
                }
            };


            RequestQueue requestQueue = Volley.newRequestQueue(agregar_p.this);
            requestQueue.add(request);



        }




    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}