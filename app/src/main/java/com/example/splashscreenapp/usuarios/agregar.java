package com.example.splashscreenapp.usuarios;

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
import com.example.splashscreenapp.MainActivity2;
import com.example.splashscreenapp.R;

import java.util.HashMap;
import java.util.Map;

public class agregar extends AppCompatActivity {

    EditText txtNombres, txtApellidos, txtNumero_telefono, txtEmail, txtContraseña;
    Button btn_insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        txtNombres = findViewById(R.id.nombre_p);
        txtApellidos = findViewById(R.id.precio_p);
        txtEmail = findViewById(R.id.info_p);
        txtNumero_telefono = findViewById(R.id.descripcion_p);
        txtContraseña = findViewById(R.id.contraseña);


        btn_insert = findViewById(R.id.btnInsert);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insertData();
            }
        });
    }

    private void insertData() {

        final String nombres = txtNombres.getText().toString().trim();
        final String apellidos = txtApellidos.getText().toString().trim();
        final String email = txtEmail.getText().toString().trim();
        final String numero_telefono = txtNumero_telefono.getText().toString().trim();
        final String contraseña = txtContraseña.getText().toString().trim();



        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("cargando...");

        if(nombres.isEmpty()){
            Toast.makeText(this, "ingrese nombre", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(apellidos.isEmpty()){
            Toast.makeText(this, "Ingrese tus apellidos", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(email.isEmpty()){
            Toast.makeText(this, "Ingrese tu email ", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(numero_telefono.isEmpty()){
            Toast.makeText(this, "Ingrese tu numero telefonico", Toast.LENGTH_SHORT).show();
            return;
        }

        else if(contraseña.isEmpty()){
            Toast.makeText(this, "Ingrese tu contraseña", Toast.LENGTH_SHORT).show();
            return;
        }


        else{
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "http://10.0.2.2/proyecto/usuarios_app/insertar_.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if(response.equalsIgnoreCase("datas insertados")){
                                Toast.makeText(agregar.this, "datas insertados", Toast.LENGTH_SHORT).show();



                                progressDialog.dismiss();
                                startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                                finish();
                            }
                            else{
                                Toast.makeText(agregar.this, response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(agregar.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();

                    params.put("nombres",nombres);
                    params.put("apellidos",apellidos);
                    params.put("email",email);
                    params.put("numero_telefono",numero_telefono);
                    params.put("contraseña",contraseña);





                    return params;
                }
            };


            RequestQueue requestQueue = Volley.newRequestQueue(agregar.this);
            requestQueue.add(request);



        }




    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}