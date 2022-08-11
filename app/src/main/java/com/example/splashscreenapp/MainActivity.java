package com.example.splashscreenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;


public class  MainActivity extends AppCompatActivity {
    private TextView textView;
    private RelativeLayout relativeLayout;
    private Button ver;
    private CardView cardView;
    private ViewFlipper flipper;
    private RecyclerView recycler, recycler2 , rvNumbers;
    private RecyclerView.Adapter adapter;
    private ProductoAdapter adapter2;
    private FragmentManager fragmentManager;
    private RecyclerView.LayoutManager LManager;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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

        items.add(new Videojuegos(R.drawable.s, "Pelada fresca", 200));
        items.add(new Videojuegos(R.drawable.platano, "los mejores productos con la mejor calidad", 12));
        items.add(new Videojuegos(R.drawable.cafe, "los productos mas frescos y deliciosos", 32));
        items.add(new Videojuegos(R.drawable.s, "100% del campo", 66));
        items.add(new Videojuegos(R.drawable.zana, "", 10));


        LManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recycler.setLayoutManager(LManager);

        adapter = new VideojuegosAdapter(items);
        recycler.setAdapter(adapter);



        // codigo  reciclador para los productos

        // data to populate the RecyclerView with
        String[] data = {"HOLA","3","4","5","6"};

        // set up the RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvnumbers);
        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter2 = new ProductoAdapter(this, data,R.drawable.cafe);
        adapter2.setClickListener(this);
        recyclerView.setAdapter(adapter2);



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
}




