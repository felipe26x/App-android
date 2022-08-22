package com.example.splashscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.splashscreenapp.usuarios.agregar;

import java.util.Hashtable;
import java.util.Map;

public class Login extends AppCompatActivity {

    private Button Iniciarsesion , registrar;
    private TextView contraseña, textingresa;
    private EditText txtuser, txtContraseña;
    private CheckBox recordar;
    String URL_SERVIDOR = "http://10.0.2.2/proyecto/login.php";
    float v = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtuser = findViewById(R.id.txtuser);
        txtContraseña = findViewById(R.id.txtcontraseña);
        Iniciarsesion = findViewById(R.id.iniciarsesion);
        registrar = findViewById(R.id.registrar);
        textingresa = findViewById(R.id.textingresa);
        contraseña = findViewById(R.id.contraseñaolvidada);
        recordar = findViewById(R.id.checkBox);


        txtuser.setTranslationX(800);
        textingresa.setTranslationX(800);
        registrar.setTranslationX(800);
        txtContraseña.setTranslationX(800);
        Iniciarsesion.setTranslationX(800);
        contraseña.setTranslationX(800);
        recordar.setTranslationX(800);


        txtuser.setAlpha(v);
        textingresa.setAlpha(v);
        contraseña.setAlpha(v);
        registrar.setAlpha(v);
        Iniciarsesion.setAlpha(v);
        contraseña.setAlpha(v);
        recordar.setAlpha(v);


        txtuser.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        textingresa.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        txtContraseña.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        registrar.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        Iniciarsesion.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        contraseña.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        recordar.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();

        Iniciarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });




    }


    public void login() {
        StringRequest stringRequest;
        stringRequest = new StringRequest(Request.Method.POST, URL_SERVIDOR,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        // En este apartado se programa lo que deseamos hacer en caso de no haber errores

                        if (response.equals("ERROR 1")) {
                            Toast.makeText(Login.this, "Se deben de llenar todos los campos.", Toast.LENGTH_SHORT).show();
                        } else if (response.equals("ERROR 2")) {
                            Toast.makeText(Login.this, "No existe este usuario.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Login.this, "Inicio de Sesion exitoso.", Toast.LENGTH_LONG).show();
                             Intent intent = new Intent(Login.this, MainActivity.class);
                             startActivity(intent);





                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // En caso de tener algun error en la obtencion de los datos
                Toast.makeText(Login.this, "ERROR AL INICIAR SESION", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                // En este metodo se hace el envio de valores de la aplicacion al servidor
                Map<String, String> parametros = new Hashtable<String, String>();
                parametros.put("usuario", txtuser.getText().toString().trim());
                parametros.put("contraseña", txtContraseña.getText().toString().trim());

                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(Login.this);
        requestQueue.add(stringRequest);
    }

    public void registrar(View view) {
        Intent intent = new Intent(Login.this , agregar.class);
        startActivity(intent);

    }
}