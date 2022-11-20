package dev.boca.actividad2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Este metodo es para abrir la pagina web
    public void OpenWeb(View view) {
        url = "https://concursdecastells.cat";

        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        // esta comprobacion es para poder abrir correctamente la pagina web
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else {
            Log.d("ImplicitIntents", "No funciona este intent");
        }
    }

    // Este metodo es para abrir el Google Maps con la ubicacion
    public void OpenLocation(View view) {
        String loc = "iFP Hospitalet de Llobregat";

        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if(intent.resolveActivity(getPackageManager()) != null) startActivity(intent);
        else Log.d("ImplicitIntents", "No funciona este intent");
    }

    // Este metodo es para abrir el numero de telefono para llamar
    public void OpenNumber(View view) {
        String number = "935 47 32 57";

        Uri addressUri = Uri.parse("tel:"+number);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if(intent.resolveActivity(getPackageManager()) != null) startActivity(intent);
        else Log.d("ImplicitIntents", "No funciona este intent");
    }

    // Con este metodo nos vamos a la pantalla del Test
    public void launchTestActivity(View view) {
        Intent intent = new Intent(this, TestActivity.class);
       startActivity(intent);
    }

    // Con este metodo nos vamos a la pantalla de resultado
    public void launchResultactivity(View view){
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }
}