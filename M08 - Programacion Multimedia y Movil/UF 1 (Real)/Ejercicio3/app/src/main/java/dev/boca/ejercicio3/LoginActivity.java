package dev.boca.ejercicio3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void launchHomeActivity(View view) {
        EditText editTextEmail = findViewById(R.id.EditTextEmail);
        EditText editTextPassword = findViewById(R.id.EditTextPassword);

//        String email = String.valueOf(editTextEmail.getText());
//        String password = String.valueOf(editTextPassword.getText());
        String email = "ejemplo@ejemplo.com";
        String password = "Ejemplo123.";
        if(email.equalsIgnoreCase("") || password.equalsIgnoreCase("")) seeAlertDialog(0);
        else if(!email.equalsIgnoreCase("ejemplo@ejemplo.com")) seeAlertDialog(1);
        else if(!password.equalsIgnoreCase("Ejemplo123.")) seeAlertDialog(1);
        else seeAlertDialog(-1);
    }

    public void seeAlertDialog(int msg){
        String title = "", message = "";

        if(msg == 0) {
            title = "Datos no introducidos";
            message = "No has introducido tu correo electronico o tu contraseña";
        }else if(msg == 1){
            title = "Correo electronico incorrecto";
            message = "El correo electronico que has introducido es incorrecto.";
        }else if(msg == 2){
            title = "Contraseña incorrecta.";
            message = "La contraseña que has introducido es incorrecto";
        }else{
            Intent intent = new Intent(this, ProductsActivity.class);
            startActivity(intent);
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("Aceptar", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}