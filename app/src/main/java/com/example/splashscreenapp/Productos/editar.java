package com.example.splashscreenapp.Productos;

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

    EditText edId, edNombre,edPrecio, edInformacion_de_produccion, edDescripcion;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        edId = findViewById(R.id.id);
        edNombre = findViewById(R.id.nombre);
        edPrecio = findViewById(R.id.precio);
        edInformacion_de_produccion = findViewById(R.id.info);
        edDescripcion = findViewById(R.id.descripcion);


        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");


        edId.setText(MainActivity2.employeeArrayList.get(position).getId());
        edNombre.setText(MainActivity2.employeeArrayList.get(position).getNombres());
        edPrecio.setText(MainActivity2.employeeArrayList.get(position).getApellidos());
        edInformacion_de_produccion.setText(MainActivity2.employeeArrayList.get(position).getEmail());
        edDescripcion.setText(MainActivity2.employeeArrayList.get(position).getNumero_telefono());






    }

    public void actualizar(View view) {
        final String id = edId.getText().toString();
        final String nombre = edNombre.getText().toString();
        final String precio = edPrecio.getText().toString();
        final String informacion_de_produccion = edInformacion_de_produccion.getText().toString();
        final String descripcion = edDescripcion.getText().toString();







        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Actualizando....");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, "http://10.0.2.2/proyecto/Producto_app/actualizar_.php",
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
                params.put("nombre",nombre);
                params.put("precio",precio);
                params.put("informacion_de_produccion",informacion_de_produccion);
                params.put("descripcion",descripcion);




                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(editar.this);
        requestQueue.add(request);





    }
}