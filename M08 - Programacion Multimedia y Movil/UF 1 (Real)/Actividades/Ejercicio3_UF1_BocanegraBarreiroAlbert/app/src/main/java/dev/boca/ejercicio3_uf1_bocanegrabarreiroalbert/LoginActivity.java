package dev.boca.ejercicio3_uf1_bocanegrabarreiroalbert;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void launchHomeActivity(View view){
        EditText editTextEmail = findViewById(R.id.EditTextEmail);
        EditText editTextPassword = findViewById(R.id.EditTextPassword);

        String email = String.valueOf(editTextEmail.getText());
        String password = String.valueOf(editTextPassword.getText());

        if(email.equalsIgnoreCase("") || password.equalsIgnoreCase("")) seeAlertDialog(0);
        else if(!email.equalsIgnoreCase("ejemplo@ejemplo.com")) seeAlertDialog(1);
        else if(!password.equals("Ejemplo123.")) seeAlertDialog(2);
        else seeAlertDialog(-1);
        //Snackbar.make(findViewById(R.id.logo), R.string.app_name, Snackbar.LENGTH_SHORT).show();
    }


    public void seeAlertDialog(int mesg) {
        String title = "", message = "";
        if(mesg == 0){
            title = "Datos no introducidos";
            message = "No has introducido tu correo electronico o tu contraseña";
        }else if(mesg == 1){
            title = "Correo electronico incorrecto";
            message = "El Correo Electronico que has introducido es incorrecto";
        }else if(mesg == 2){
            title = "Contraseña incorrecta";
            message = "La contraseña que has introducido es incorrecta";
        }else{
            title = "Funciona correctamente";
            message = "El correo elctronico y la contraseña funciona correctamente";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("Aceptar", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}