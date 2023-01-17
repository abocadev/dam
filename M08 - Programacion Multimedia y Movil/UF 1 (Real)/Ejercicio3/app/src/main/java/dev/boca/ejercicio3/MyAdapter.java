package dev.boca.ejercicio3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Product> products;
    public MyAdapter() {
        this.products = Product.getProducts();
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.products_item, parent, false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(products.get(position).getTitle(), products.get(position).getQuantity(), products.get(position).getPrice());
    }
    @Override
    public int getItemCount() {
        return products.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView priceTextView;
        public MyViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title_burger);
            priceTextView = itemView.findViewById(R.id.price_burger);
        }
        public void bind(String text, int quantity, float price) {
            titleTextView.setText(text);
            priceTextView.setText(quantity + "x " + price + "€");
        }
    }
}
