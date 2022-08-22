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
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.splashscreenapp.Productos.Productos;
import com.example.splashscreenapp.adaptador.AdapterP;
import com.example.splashscreenapp.adaptador.RecyclerAdapter;
import com.example.splashscreenapp.model.ItemList;
import com.example.splashscreenapp.retrofit_data.RetrofilApiService;
import com.example.splashscreenapp.retrofit_data.RetrofitClient;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class  MainActivity extends AppCompatActivity implements RecyclerAdapter.RecyclerItemClick, SearchView.OnQueryTextListener {
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


    // CODIGO PARA LLAMAR LOS PRODUCTOS

    private RecyclerView rvLista;
    private SearchView svSearch;
    private RecyclerAdapter adapter;
    private List<ItemList> items;
    private RetrofilApiService retrofilApiService;











    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initValues();








        int imgarray[]={R.drawable.publicidad,R.drawable.cafe,R.drawable.cacao};
        flipper=(ViewFlipper)findViewById(R.id.flipper);

        for (int i=0;i<imgarray.length;i++)
            showimage(imgarray[i]);




        drawerLayout = findViewById(R.id.DrawerLayout);
        navigationView = findViewById(R.id.NavigationView);
        toolbar=findViewById(R.id.app_Bar);





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



                    case R.id.Favoritos:
                        Intent intent2 = new Intent(MainActivity.this, Favoritos.class);
                        startActivity(intent2);
                        break;


                    case R.id.Administraccion:
                        Intent intent3 = new Intent(MainActivity.this, admin.class);
                        startActivity(intent3);
                        break;












                }
                return false;
            }
        });






        // codigo reciclador para las publicidades


        recycler = findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);




        List items = new ArrayList();

        items.add(new Videojuegos(R.drawable.frutas, "Frutas", 200));
        items.add(new Videojuegos(R.drawable.carnes, "Carnes", 12));
        items.add(new Videojuegos(R.drawable.verduras, "verduras", 32));
        items.add(new Videojuegos(R.drawable.granos1, "Granos", 66));



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







    private void initViews(){
        rvLista = findViewById(R.id.rvLista);


    }

    private void initValues(){
        retrofilApiService = RetrofitClient.getApiService();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvLista.setLayoutManager(manager);

        getItemSQL();

    }




    private void getItemSQL(){
        retrofilApiService.getItemsDB().enqueue(new Callback<List<ItemList>>() {
            @Override
            public void onResponse(Call<List<ItemList>> call, Response<List<ItemList>> response) {
                items = response.body();
                adapter = new RecyclerAdapter(items, MainActivity.this);
                rvLista.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<ItemList>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error"+t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });

    }






    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filter(newText);
        return false;
    }

    @Override
    public void itemClick(ItemList item) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("itemDetail", item);
        startActivity(intent);

    }




}




