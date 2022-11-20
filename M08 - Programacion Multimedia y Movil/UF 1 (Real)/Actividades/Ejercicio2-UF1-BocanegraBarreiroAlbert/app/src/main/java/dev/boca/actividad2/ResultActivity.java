package dev.boca.actividad2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    static boolean Pregunta1Seleccionada = false;
    static boolean Pregunta2Seleccionada = false;
    static boolean Pregunta3Seleccionada = false;

    private static TextView mShowCorrect, mShowWrong, mShowNoSelect, mShowResult;
    static int PreguntasAcertadas = 0;
    static int PreguntasFalladas = 0;
    static int PreguntasNoSeleccionadas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mShowCorrect = (TextView) findViewById(R.id.RespuestasCorrectasScreenResult);
        mShowWrong = (TextView) findViewById(R.id.RespuestasIncorrectasScreenResult);
        mShowNoSelect = (TextView) findViewById(R.id.RespuestasSinResponderScreenResult);
        mShowResult = (TextView) findViewById(R.id.ResultadoFinalScreenResult);

        if((PreguntasAcertadas + PreguntasFalladas) < 3) {
            if (Pregunta1Seleccionada) {
                if (TestActivity.Pregunta1Acertada) PreguntasAcertadas++;
                else if (!TestActivity.Pregunta1Acertada) PreguntasFalladas++;
                if(PreguntasNoSeleccionadas > 0)PreguntasNoSeleccionadas--;
            } else PreguntasNoSeleccionadas++;

            if (Pregunta2Seleccionada) {
                if (TestActivity.Pregunta2Acertada) PreguntasAcertadas++;
                else if (!TestActivity.Pregunta2Acertada) PreguntasFalladas++;
                if(PreguntasNoSeleccionadas > 0)PreguntasNoSeleccionadas--;
            } else PreguntasNoSeleccionadas++;

            if (Pregunta3Seleccionada) {
                if (TestActivity.Pregunta3Acertada) PreguntasAcertadas++;
                else if (!TestActivity.Pregunta3Acertada) PreguntasFalladas++;
                if(PreguntasNoSeleccionadas > 0)PreguntasNoSeleccionadas--;
            } else PreguntasNoSeleccionadas++;
        }

        ShowResults();
    }

    // Con este metodo mostramos los resultados
    public static void ShowResults(){
        // Creamos el texto de cada resultado
        String auxAcertadas = "PREGUNTAS ACERTADAS: " + Integer.toString(PreguntasAcertadas);
        String auxFalladas = "PREGUNTAS INCORRECTAS: " + Integer.toString(PreguntasFalladas);
        String auxNoSeleccionadas = "PREGUNTAS NO SELECCIONADAS: " + Integer.toString(PreguntasNoSeleccionadas);
        String auxResultadoFinal = "";

        // Indicamos si el resultado final es apto o no
        if(PreguntasNoSeleccionadas == 0){
            if(PreguntasAcertadas > 1) auxResultadoFinal = "HAS APROBADO ESTE TEST \n👍";
            else auxResultadoFinal = "HAS SUSPENDIDO ESTE TEST \n👎";
        } else auxResultadoFinal = "TODAVIA TE FALTAN PREGUNTAS POR RESPONDER\n😐";

        // Mostramos el resultado
        mShowCorrect.setText(auxAcertadas);
        mShowWrong.setText(auxFalladas);
        mShowNoSelect.setText(auxNoSeleccionadas);
        mShowResult.setText(auxResultadoFinal);
    }
}