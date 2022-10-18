package dev.boca.actividad2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void CorrectAnswerQuestion1(View view) {
        Toast toast = Toast.makeText(this,
                R.string.PreguntaAcertada1,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void WrongAnswerQuestion1(View view) {
        Toast toast = Toast.makeText(this,
                R.string.PreguntaFallada1,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void CorrectAnswerQuestion2(View view) {
        Toast toast = Toast.makeText(this,
                R.string.PreguntaAcertada2,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void WrongAnswerQuestion2(View view) {
        Toast toast = Toast.makeText(this,
                R.string.PreguntaFallada2,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void CorrectAnswerQuestion3(View view) {
        Toast toast = Toast.makeText(this,
                R.string.PreguntaAcertada3,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void WrongAnswerQuestion3(View view) {
        Toast toast = Toast.makeText(this,
                R.string.PreguntaFallada3,
                Toast.LENGTH_SHORT);
        toast.show();
    }
}