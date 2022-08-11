package com.example.splashscreenapp;

import androidx.appcompat.app.AppCompatActivity;

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
    }
}