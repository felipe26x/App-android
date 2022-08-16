package com.example.splashscreenapp.adaptador;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.splashscreenapp.R;
import com.example.splashscreenapp.model.ItemList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {
    private List<ItemList> items;
    private List<ItemList> originalItems;
    private RecyclerItemClick itemClick;

    private String doamin_image = "http://10.0.2.2/proyecto/media/";
    public RecyclerAdapter(List<ItemList> items, RecyclerItemClick itemClick){
        this.items = items;
        this.itemClick = itemClick;
        this.originalItems = new ArrayList<>();
        originalItems.addAll(items);





    }

    @NonNull
    @Override
    public RecyclerAdapter.RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_list_view, parent, false);

        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerAdapter.RecyclerHolder holder, final int position) {

        final ItemList item = items.get(position);
        Picasso.get()
                .load(doamin_image+item.getimageResource())
                .into(holder.imageItem);
        holder.tvTitulo.setText(item.getnombre());
        //holder.tvDescripcion.setText(item.getDescripcion());
        holder.tvprecio.setText(item.getprecio());
        holder.itemView.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {itemClick.itemClick(item); }

            });
        }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void filter(final String strSearch) {
        if (strSearch.length() == 0) {
            items.clear();
            items.addAll(originalItems);
        }
        else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                items.clear();
                List<ItemList> collect = originalItems.stream()
                        .filter(i -> i.getnombre()
                                .toLowerCase().contains(strSearch))
                        .collect(Collectors.toList());

                items.addAll(collect);
            }
            else {
                items.clear();
                for (ItemList i : originalItems) {
                    if (i.getnombre().toLowerCase().contains(strSearch)) {
                        items.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }


    public class RecyclerHolder extends RecyclerView.ViewHolder {
        private ImageView imageItem;
        private TextView tvTitulo;
        //private TextView tvDescripcion;
        private TextView tvprecio;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);

            imageItem = itemView.findViewById(R.id.imageItem);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            //tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            tvprecio= itemView.findViewById(R.id.tvPrecio);
        }
    }
    public interface RecyclerItemClick {
        void itemClick(ItemList item);
    }
}
