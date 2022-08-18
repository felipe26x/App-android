package com.example.splashscreenapp.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.splashscreenapp.ProductoAdapter;
import com.example.splashscreenapp.Productos.Productos;
import com.example.splashscreenapp.R;

import java.util.List;

public class AdapterP extends ArrayAdapter<Productos> {

    Context context;
    List<Productos> arrayProductos;

    public AdapterP (@NonNull Context context, List<Productos> arrayProductos) {
        super(context, R.layout.list_productos,arrayProductos);
        this.context =context;
        this.arrayProductos =arrayProductos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull
    ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_productos,null,true);
        TextView tvName = view.findViewById(R.id.txt_name_p);
        TextView tvPrice = view.findViewById(R.id.txt_price_p);



        tvName.setText(arrayProductos.get(position).getNombre());
        tvPrice.setText(arrayProductos.get(position).getPrecio());


        return view;
    }
}
