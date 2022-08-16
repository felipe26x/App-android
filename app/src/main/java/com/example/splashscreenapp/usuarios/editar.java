package com.example.splashscreenapp.usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class editar extends AppCompatActivity {

    EditText edId, edNombres,edApellidos,edNombreusuario, edEmail, edNumero_telefono;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        edId = findViewById(R.id.id);
        edNombres = findViewById(R.id.nombre);
        edApellidos = findViewById(R.id.apellidos);
        edNombreusuario = findViewById(R.id.nombreusuario);
        edEmail = findViewById(R.id.email);
        edNumero_telefono = findViewById(R.id.numero_telefono);


        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");


        edId.setText(MainActivity2.employeeArrayList.get(position).getId());
        edNombres.setText(MainActivity2.employeeArrayList.get(position).getNombres());
        edApellidos.setText(MainActivity2.employeeArrayList.get(position).getApellidos());
        edNombreusuario.setText(MainActivity2.employeeArrayList.get(position).getNombreusuario());
        edEmail.setText(MainActivity2.employeeArrayList.get(position).getEmail());
        edNumero_telefono.setText(MainActivity2.employeeArrayList.get(position).getNumero_telefono());






    }

    public void actualizar(View view) {
        final String id = edId.getText().toString();
        final String nombres = edNombres.getText().toString();
        final String apellidos = edApellidos.getText().toString();
        final String nombreusuario = edNombreusuario.getText().toString();
        final String email = edEmail.getText().toString();
        final String numero_telefono = edNumero_telefono.getText().toString();







        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Actualizando....");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, "http://10.0.2.2/Proyecto/Usuarios_app/actualizar_.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(editar.this, response, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),MainActivity2.class));
                        finish();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(editar.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();

                params.put("id",id);
                params.put("nombres",nombres);
                params.put("apellidos",apellidos);
                params.put("nombreusuario",nombreusuario);
                params.put("email",email);
                params.put("numero_telefono",numero_telefono);




                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(editar.this);
        requestQueue.add(request);





    }
}