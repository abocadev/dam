package dev.boca.actividad2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {

    static boolean Pregunta1Acertada;
    static boolean Pregunta2Acertada;
    static boolean Pregunta3Acertada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }


    public void CorrectAnswerQuestion1(View view) {
        ResultActivity.Pregunta1Seleccionada = true;
        Pregunta1Acertada = true;
    }

    public void WrongAnswerQuestion1(View view) {
        Pregunta1Acertada = false;
        ResultActivity.Pregunta1Seleccionada = true;
    }

    public void CorrectAnswerQuestion2(View view) {
        Pregunta2Acertada = true;
        ResultActivity.Pregunta2Seleccionada = true;
    }

    public void WrongAnswerQuestion2(View view) {
        Pregunta2Acertada = false;
        ResultActivity.Pregunta2Seleccionada = true;
    }

    public void CorrectAnswerQuestion3(View view) {
        Pregunta3Acertada = true;
        ResultActivity.Pregunta3Seleccionada = true;
    }

    public void WrongAnswerQuestion3(View view) {
        Pregunta3Acertada = false;
        ResultActivity.Pregunta3Seleccionada = true;
    }
}