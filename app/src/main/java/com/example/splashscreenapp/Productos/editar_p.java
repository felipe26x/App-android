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
import com.example.splashscreenapp.MainActivity3;
import com.example.splashscreenapp.R;

import java.util.HashMap;
import java.util.Map;

public class editar_p extends AppCompatActivity {

    EditText edId, edNombre,edPrecio, edInformacion_de_produccion, edDescripcion;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_producto);

        edId = findViewById(R.id.id);
        edNombre = findViewById(R.id.nombre);
        edPrecio = findViewById(R.id.precio);
        edInformacion_de_produccion = findViewById(R.id.informacion_de_produccion);
        edDescripcion = findViewById(R.id.descripcion);


        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");


        edId.setText(MainActivity3.productArrayList.get(position).getId());
        edNombre.setText(MainActivity3.productArrayList.get(position).getNombre());
        edPrecio.setText(MainActivity3.productArrayList.get(position).getPrecio());
        edInformacion_de_produccion.setText(MainActivity3.productArrayList.get(position).getInformacion_de_produccion());
        edDescripcion.setText(MainActivity3.productArrayList.get(position).getDescripcion());






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

        StringRequest request = new StringRequest(Request.Method.POST, "http://10.0.2.2/Proyecto/Productos_app/actualizar_.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(editar_p.this, response, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),MainActivity3.class));
                        finish();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(editar_p.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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

        RequestQueue requestQueue = Volley.newRequestQueue(editar_p.this);
        requestQueue.add(request);





    }
}