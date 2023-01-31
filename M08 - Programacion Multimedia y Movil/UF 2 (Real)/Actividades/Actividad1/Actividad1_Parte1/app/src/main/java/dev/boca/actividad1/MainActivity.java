package dev.boca.actividad1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.GestureDetectorCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GestureDetectorCompat gdc; // Variable para la deteccion de gestos.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializamos las variables para la imagen y para la deteccion de gestos.
        ImageView image = (ImageView) findViewById(R.id.imagen);
        gdc = new GestureDetectorCompat(getApplicationContext(), new GestureListener());

        // Esta esperando, a ver si tocan la imagen y cuando la tocan se lanza la clase
        image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gdc.onTouchEvent(motionEvent);
                return true;
            }
        });
    }

    // Metodo donde almacena el evento
    public boolean onTouchEvent(MotionEvent event){
        gdc.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    // Clase que escucha el evento
    private class GestureListener implements GestureDetector.OnGestureListener {
        private static final int SWIPE_DISTANCE_THRESHOULD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;


        @Override
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        // Metodo cuando se detecta que han presiando
        @Override
        public void onShowPress(MotionEvent motionEvent) {}

        // Metodo que detecta cuando se ha tocado
        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }

        // Metodo que detecta si se ha hecho scroll
        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            return false;
        }

        // Metodo que detecta si se ha dejado presionado durante mucho rato
        @Override
        public void onLongPress(MotionEvent motionEvent) {}

        // Metodo que detecta si se ha desplazado
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float v, float v1) {
            float distanceX = e2.getX() - e1.getX();
            float distanceY = e2.getY() - e1.getY();

            /* Comprobamos que se ha hecho desplaza horizontalmente o no, en el caso que se haya hecho
            *  devolvera un boolean "true". Y en el caso de que no se haya hecho devolvera un
            *  boolean "false".
             */
            if(Math.abs(distanceX) > Math.abs(distanceY) &&
                Math.abs(distanceX) > SWIPE_DISTANCE_THRESHOULD &&
                Math.abs(distanceX) > SWIPE_VELOCITY_THRESHOLD){
                if(distanceX > 0) onSwipeRight(); // Si se ha hecho scroll hacia la derecha, ejecuta el siguiente metodo
                else onSwipeLeft(); // O si se ha hecho scroll hacia la izquierda, ejecuta el otro metodo
                return true;
            }
            return false;
        }
    }

    // Metodo que se ejecuta cuando se le ha dado a la derecha
    private void onSwipeRight() {
        // Obtenemos la imagen y la descripcion de la imagen
        // Obtenemos la imagen para cambiarla
        // Obtenemos la descripcion para saber con mas facilidad en que imagen esta
        // y asi cambiamos la descripcion de la imagen.
        ImageView image = (ImageView) findViewById(R.id.imagen);
        String imgDesc = (String) image.getContentDescription();
        switch (imgDesc){
            case "imagen_1":
                image.setImageResource(R.drawable.imagen_three);
                image.setContentDescription("imagen_3");
                break;

            case "imagen_2":
                image.setImageResource(R.drawable.imagen_one);
                image.setContentDescription("imagen_1");
                break;

            case "imagen_3":
                image.setImageResource(R.drawable.imagen_two);
                image.setContentDescription("imagen_2");
                break;

            default: break;
        }
    }

    // Metodo que se ejecuta cuando se le ha dado a la izquierda
    private void onSwipeLeft() {
        // Obtenemos la imagen y la descripcion de la imagen
        // Obtenemos la imagen para cambiarla
        // Obtenemos la descripcion para saber con mas facilidad en que imagen esta
        // y asi cambiamos la descripcion de la imagen.
        ImageView image = (ImageView) findViewById(R.id.imagen);
        String imgDesc = (String) image.getContentDescription();
        switch (imgDesc){
            case "imagen_1":
                image.setImageResource(R.drawable.imagen_two);
                image.setContentDescription("imagen_2");
                break;

            case "imagen_2":
                image.setImageResource(R.drawable.imagen_three);
                image.setContentDescription("imagen_3");
                break;

            case "imagen_3":
                image.setImageResource(R.drawable.imagen_one);
                image.setContentDescription("imagen_1");
                break;

            default: break;
        }
    }
}