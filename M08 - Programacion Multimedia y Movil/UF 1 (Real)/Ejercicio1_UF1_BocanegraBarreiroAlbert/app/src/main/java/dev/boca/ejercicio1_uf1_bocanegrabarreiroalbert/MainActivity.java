package dev.boca.ejercicio1_uf1_bocanegrabarreiroalbert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int correct = 0;
    private TextView mShowCorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCorrect = (TextView) findViewById(R.id.showCorrectAnswers);
    }

    public void showCorrect(View view) {
        if (correct < 3) {
            Toast toast = Toast.makeText(this, "Respuesta Correcta", Toast.LENGTH_SHORT);
            toast.show();

            correct++;
            String aux = "Respuestas correctas: " + Integer.toString(correct);
            if (mShowCorrect != null) mShowCorrect.setText(aux);
        }else{
            Toast.makeText(this, "No puedes seleccionar mas respuestas", Toast.LENGTH_SHORT).show();
        }
    }

    public void showWrong(View view) {
        if(correct < 3){

        Toast toast = Toast.makeText(this, "Respuesta Incorrecta", Toast.LENGTH_SHORT);
        toast.show();
        }else{
            Toast.makeText(this, "No puedes selecionar mas respuestas", Toast.LENGTH_SHORT).show();
        }
    }
}