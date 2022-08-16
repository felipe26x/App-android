package com.example.splashscreenapp.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.splashscreenapp.R;
import com.example.splashscreenapp.usuarios.Usuarios;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends ArrayAdapter<Usuarios> {

Context context;
List<Usuarios> arrayUsuarios;
private String doamin_image = "http://10.0.2.2/proyecto/media/userperfil";

    public Adapter(@NonNull Context context, List<Usuarios> arrayUsuarios) {
        super(context, R.layout.list_usuarios,arrayUsuarios);
        this.context =context;
        this.arrayUsuarios =arrayUsuarios;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_usuarios,null,true);

        TextView tvID = view.findViewById(R.id.txt_id);
        TextView tvName = view.findViewById(R.id.txt_name);


        tvID.setText(arrayUsuarios.get(position).getId());
        tvName.setText(arrayUsuarios.get(position).getNombres());



        return view;
    }
}
