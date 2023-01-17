package dev.boca.ejercicio3;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView titleTextView;
        public TextView infoTextView;
        public ImageView imgImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.title_burger);
            infoTextView = (TextView) itemView.findViewById(R.id.info_burger);
            imgImageView = (ImageView) itemView.findViewById(R.id.image_burger);
        }
    }

    private List<Product> mProducts;

    public ProductAdapter(List<Product> products) {
        mProducts = products;
    }

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context content = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(content);

        View productView = inflater.inflate(R.layout.products_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(productView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ViewHolder holder, int position) {
        Product product = mProducts.get(position);
        TextView titleTextView = holder.titleTextView;
        titleTextView.setText(product.getTitle());

        TextView infoTextView = holder.infoTextView;
        infoTextView.setText(product.getDescription());


        ImageView imgImageView = holder.imgImageView;
        imgImageView.setImageResource(product.getImg());
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }
}
