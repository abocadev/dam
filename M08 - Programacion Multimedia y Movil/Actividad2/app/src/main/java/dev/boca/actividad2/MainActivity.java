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

    public void OpenWeb(View view) {
        url = "https://concursdecastells.cat";

        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else {
            Log.d("ImplicitIntents", "No funciona este intent");
        }
    }

    public void OpenLocation(View view) {
        String loc = "iFP Hospitalet de Llobregat";

        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if(intent.resolveActivity(getPackageManager()) != null) startActivity(intent);
        else Log.d("ImplicitIntents", "No funciona este intent");
    }

    public void OpenNumber(View view) {
        String number = "608230454";

        Uri addressUri = Uri.parse("tel:"+number);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if(intent.resolveActivity(getPackageManager()) != null) startActivity(intent);
        else Log.d("ImplicitIntents", "No funciona este intent");
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, TestActivity.class);
        startActivityForResult(intent, 1);
    }
}