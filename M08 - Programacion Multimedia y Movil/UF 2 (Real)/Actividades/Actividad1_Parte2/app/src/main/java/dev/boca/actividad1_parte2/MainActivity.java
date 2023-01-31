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

    private GestureDetectorCompat gdc;
    int anim_alpha, anim_move, anim_resize, rotate_ball;
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtenemos las animaciones.
        anim_alpha = R.anim.alpha_ball;
        anim_move = R.anim.move_ball;
        anim_resize = R.anim.resize_ball;
        rotate_ball = R.anim.rotate_ball;

        image = (ImageView) findViewById(R.id.image);
        gdc = new GestureDetectorCompat(getApplicationContext(), new GestureListener());
        image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gdc.onTouchEvent(motionEvent);
                return true;
            }
        });
    }

    public boolean onTouchEvent(MotionEvent event){
        gdc.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private class GestureListener implements GestureDetector.OnGestureListener {
        private static final int SWIPE_DISTANCE_THRESHOULD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override
        public void onShowPress(MotionEvent motionEvent) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            animationFound(anim_resize);
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            animationFound(anim_move);
            return true;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {
            animationFound(anim_alpha);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float v, float v1) {
            float distanceX = e2.getX() - e1.getX();
            float distanceY = e2.getY() - e1.getY();
            if(Math.abs(distanceX) > Math.abs(distanceY) &&
                    Math.abs(distanceX) > SWIPE_DISTANCE_THRESHOULD &&
                    Math.abs(distanceX) > SWIPE_VELOCITY_THRESHOLD){
                animationFound(rotate_ball);
                return true;
            }
            return false;
        }
    }

    public void animationFound(int anim){
        Animation animacion = AnimationUtils.loadAnimation(getApplicationContext(), anim);
        image.startAnimation(animacion);
    }
}