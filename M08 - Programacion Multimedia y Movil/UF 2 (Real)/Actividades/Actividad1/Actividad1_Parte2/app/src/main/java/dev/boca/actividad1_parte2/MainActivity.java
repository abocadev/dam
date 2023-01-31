package dev.boca.actividad1_parte2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GestureDetectorCompat gdc; // Variable para la detecccion de gestos
    int anim_alpha, anim_move, anim_resize, anim_rotate; // Variables de tipo int, para indentificar con facilidad el nombre de los archivos que contienen las animaciones.
    private ImageView image; // Variable que contiene la imagen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtenemos las animaciones.
        anim_alpha = R.anim.alpha_ball;
        anim_move = R.anim.move_ball;
        anim_resize = R.anim.resize_ball;
        anim_rotate = R.anim.rotate_ball;

        // Inicializamos las variables para la imagen y para la deteccion de gastos.
        image = (ImageView) findViewById(R.id.image);
        gdc = new GestureDetectorCompat(getApplicationContext(), new GestureListener());

        // Esta esperando, a ver si tocan la imagen y cuando la tocan se ejecuta la clase.
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

        // Metodo que detecta cuando se ha presionado
        @Override
        public void onShowPress(MotionEvent motionEvent) {

        }

        // Metodo que detecta cuando se ha tocado y ejecuta la animacion de cambiar de tamaño
        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            animationFound(anim_resize);
            return true;
        }

        // Metodo que detecta cuando se ha hecho Scroll y ejecuta la animacion de que esta en movimiento
        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            animationFound(anim_move);
            return true;
        }

        // Metodo que detecta si se ha dejado presionado durante un buen rato y ejecuta la animacion que ha desaparecer y volver a aparecer la imagen.
        @Override
        public void onLongPress(MotionEvent motionEvent) {
            animationFound(anim_alpha);
        }

        // Metodo que detecta si se ha desplazado horizontalmente y ejecuta una animacion de rotacion
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float v, float v1) {
            float distanceX = e2.getX() - e1.getX();
            float distanceY = e2.getY() - e1.getY();

            /* Comprobamos que se ha hecho desplaza horizontalmente o no, en el caso que se haya hecho
             * devolvera un boolean "true" y ejecutara la animacion de rotacion. Y en el caso de que
             * no se haya hecho devolvera un boolean "false".
             */
            if(Math.abs(distanceX) > Math.abs(distanceY) &&
                    Math.abs(distanceX) > SWIPE_DISTANCE_THRESHOULD &&
                    Math.abs(distanceX) > SWIPE_VELOCITY_THRESHOLD){
                animationFound(anim_rotate);
                return true;
            }
            return false;
        }
    }

    // Metodo que inicia la animacion
    public void animationFound(int anim){
        Animation animacion = AnimationUtils.loadAnimation(getApplicationContext(), anim);
        image.startAnimation(animacion);
    }
}