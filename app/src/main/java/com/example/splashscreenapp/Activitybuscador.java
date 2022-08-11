package com.example.splashscreenapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.splashscreenapp.adaptador.RecyclerAdapter;
import com.example.splashscreenapp.model.ItemList;
import com.example.splashscreenapp.retrofit_data.RetrofilApiService;
import com.example.splashscreenapp.retrofit_data.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activitybuscador extends AppCompatActivity implements RecyclerAdapter.RecyclerItemClick, SearchView.OnQueryTextListener {

    private RecyclerView rvLista;
    private SearchView svSearch;
    private RecyclerAdapter adapter;
    private List<ItemList> items;
    private RetrofilApiService retrofilApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador);

        initViews();
        initValues();
        initListener();
    }

    private void initViews(){
        rvLista = findViewById(R.id.rvLista);
        svSearch = findViewById(R.id.svSearch);

    }

    private void initValues(){
        retrofilApiService = RetrofitClient.getApiService();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvLista.setLayoutManager(manager);

        getItemSQL();

    }

    private void initListener() { svSearch.setOnQueryTextListener(this);}



    private void getItemSQL(){
        retrofilApiService.getItemsDB().enqueue(new Callback<List<ItemList>>() {
            @Override
            public void onResponse(Call<List<ItemList>> call, Response<List<ItemList>> response) {
                items = response.body();
                adapter = new RecyclerAdapter(items, Activitybuscador.this);
                rvLista.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<ItemList>> call, Throwable t) {
                Toast.makeText(Activitybuscador.this, "Error"+t.getMessage(), Toast.LENGTH_SHORT).show();


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