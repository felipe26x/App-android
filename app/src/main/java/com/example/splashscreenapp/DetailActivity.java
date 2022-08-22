package com.example.splashscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.splashscreenapp.model.ItemList;
import com.example.splashscreenapp.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageItemDetail;
    private TextView tvNombreDetail;
    private TextView tvDescripcionDetail, tvPrecioDetail;
    private ItemList itemDetail;
    private String doamin_image = "http://10.0.2.2/proyecto/media/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle(getClass().getSimpleName());
        initViews();
        initValues();
    }
    private void initViews() {
        imageItemDetail = findViewById(R.id.imageItemDetail);
        tvNombreDetail = findViewById(R.id.tvNombreDetail);
        tvDescripcionDetail = findViewById(R.id.tvDescripcionDetail);
        tvPrecioDetail = findViewById(R.id.tvPrecioDetail);
    }

    private void initValues(){
        itemDetail = (ItemList) getIntent().getExtras()
                .getSerializable("itemDetail");

        //imgItemDetail.setImageResource(Integer.parseInt(itemDetail.getImgResource()));
        Picasso.get()
                .load(doamin_image+itemDetail.getimageResource())
                .into(imageItemDetail);
        tvNombreDetail.setText(itemDetail.getnombre());
        tvDescripcionDetail.setText(itemDetail.getDescripcion());
        tvPrecioDetail.setText(itemDetail.getprecio());
    }

    public void volver(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


    public void ubi(View view) {
        Intent intent = new Intent(this,Location.class);
        startActivity(intent);
    }
    public void contactar(View view) {
        Intent i = new Intent(android.content.Intent.ACTION_DIAL,
                Uri.parse("tel:+573168646125")); //
        startActivity(i);
    }

    public void perfil(View view) {
        Intent intent = new Intent(this,perfil1.class);
        startActivity(intent);
    }
}