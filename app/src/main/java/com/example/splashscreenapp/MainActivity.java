package com.example.splashscreenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.splashscreenapp.Productos.Productos;
import com.example.splashscreenapp.adaptador.AdapterP;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class  MainActivity extends AppCompatActivity {
    private TextView textView;
    private RelativeLayout relativeLayout;
    private Button ver;
    private CardView cardView;
    private ViewFlipper flipper;
    private RecyclerView recycler, recycler2;
    private RecyclerView.Adapter adapter2;
    //private ProductoAdapter adapter2;
    private FragmentManager fragmentManager;
    private RecyclerView.LayoutManager LManager;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;



    // codigo para los traer los  productos

    ListView listView;
    AdapterP adapter;
    public static ArrayList<Productos> productArrayList = new ArrayList<>();
    String url = "http://10.0.2.2/Proyecto/Productos_app/mostrar_.php";
    Productos productos;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.myListView3);
        adapter = new AdapterP(this,productArrayList);
        listView.setAdapter(adapter);

        retrieveData();






        int imgarray[]={R.drawable.publicidad,R.drawable.cafe,R.drawable.cacao};
        flipper=(ViewFlipper)findViewById(R.id.flipper);

        for (int i=0;i<imgarray.length;i++)
            showimage(imgarray[i]);



        ver = findViewById(R.id.ver);
        drawerLayout = findViewById(R.id.DrawerLayout);
        navigationView = findViewById(R.id.NavigationView);
        toolbar=findViewById(R.id.app_Bar);



        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,descripcionproducto.class);
                startActivity(intent);
            }
        });


        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_dehaze_24);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.Home:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;


                    case R.id.categorias:
                        Intent intent1 = new Intent(MainActivity.this, Categorias2.class);
                        startActivity(intent1);
                        break;



                    case R.id.Configuracion:



                    case R.id.CerrarCesion:



                }
                return false;
            }
        });






        // codigo reciclador para las publicidades


        recycler = findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);




        List items = new ArrayList();

        items.add(new Videojuegos(R.drawable.s, "Frutas", 200));
        items.add(new Videojuegos(R.drawable.platano, "Carnes", 12));
        items.add(new Videojuegos(R.drawable.cafe, "los productos mas frescos y deliciosos", 32));
        items.add(new Videojuegos(R.drawable.s, "100% del campo", 66));
        items.add(new Videojuegos(R.drawable.zana, "", 10));


        LManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recycler.setLayoutManager(LManager);

        adapter2 = new VideojuegosAdapter(items);
        recycler.setAdapter(adapter2);



        // codigo  reciclador para los productos

        // data to populate the RecyclerView with




    }






    public void showimage(int img){
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(img);

        flipper.addView(imageView);
        flipper.setFlipInterval(3200);
        flipper.setAutoStart(true);
        flipper.setInAnimation(this, android.R.anim.fade_in);



    }


    public void fav(View view) {

        Intent intent= new Intent(MainActivity.this,Favoritos.class);
        startActivity(intent);
    }

    public void subir(View view) {
        Intent intent= new Intent(MainActivity.this,Sproducto.class);
        startActivity(intent);
    }

    public void perfil3(View view){
        Intent intent = new Intent(MainActivity. this, Login.class);
        startActivity(intent);

    }


    public void Buscador (View view){
        Intent intent = new Intent( this, Activitybuscador.class);
        startActivity(intent);

    }





    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true ;
        }
        return super.onOptionsItemSelected(item);
    }


    public void ver(View view) {
        Intent intent= new Intent(MainActivity.this,descripcionproducto.class);
        startActivity(intent);
    }

    public void listar(View view) {
        Intent intent= new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent);
    }

    public void entrar(View view) {
    }

    public void productos(View view) {
        Intent intent= new Intent(MainActivity.this,MainActivity3.class);
        startActivity(intent);
    }

    public void retrieveData(){

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        productArrayList.clear();
                        try{

                            JSONObject jsonObject = new JSONObject(response);
                            String exito = jsonObject.getString("exito");
                            JSONArray jsonArray = jsonObject.getJSONArray("datos");

                            if(exito.equals("1")){


                                for(int i=0;i<jsonArray.length();i++){

                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String id = object.getString("id");
                                    String nombre = object.getString("nombre");
                                    String precio = object.getString("precio");
                                    String informacion_de_produccion = object.getString("informacion_de_produccion");
                                    String descripcion = object.getString("descripcion");


                                    productos = new Productos(id,nombre,precio,informacion_de_produccion,descripcion);
                                    productArrayList.add(productos);
                                    adapter.notifyDataSetChanged();



                                }



                            }




                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }






                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);




    }


}




