package dev.boca.actividad2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ResultActivity extends AppCompatActivity {

    boolean Pregunta1Seleccionada = false;
    boolean Pregunta2Seleccionada = false;
    boolean Pregunta3Seleccionada = false;

    int PreguntasAcertadas = 0;
    int PreguntasFalladas = 0;
    int PreguntasNoSeleccionadas = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }
}