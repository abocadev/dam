package dev.boca.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CartActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private TextView TitleCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        recyclerView = findViewById(R.id.recyclerViewCart);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);

        float sumatotal = 0;
        for(Product product: Product.products){
            float precio = product.getPrice();
            int quantity = product.getQuantity();
            sumatotal += (precio * quantity);
        }

        TitleCart = findViewById(R.id.titleCart);
        TitleCart.setText( sumatotal != 0 ? "Coste total: " + sumatotal + "€" : "No has insertado ningun producto.");
    }
}