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

    private GestureDetectorCompat gdc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image = (ImageView) findViewById(R.id.imagen);
        gdc = new GestureDetectorCompat(getApplicationContext(), new GestureListener());

        image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gdc.onTouchEvent(motionEvent);
                return true;
            }
        });

        Button boton = (Button) findViewById(R.id.button);
        boton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                return true;
            }
        });

    }

    public boolean onTouchEvent(MotionEvent event){
        gdc.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    public void openActivityTwo(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityPartTwo.class);
        startActivity(intent);
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
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float v, float v1) {
            float distanceX = e2.getX() - e1.getX();
            float distanceY = e2.getY() - e1.getY();
            if(Math.abs(distanceX) > Math.abs(distanceY) &&
                Math.abs(distanceX) > SWIPE_DISTANCE_THRESHOULD &&
                Math.abs(distanceX) > SWIPE_VELOCITY_THRESHOLD){
                if(distanceX > 0) onSwipeRight();
                else onSwipeLeft();
                return true;
            }
            return false;
        }
    }

    private void onSwipeLeft() {
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
        imgDesc = (String) image.getContentDescription();
        Toast.makeText(this, "onSwipeLeft: " + imgDesc, Toast.LENGTH_SHORT).show();
    }

    private void onSwipeRight() {
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
        imgDesc = (String) image.getContentDescription();
        Toast.makeText(this, "onSwipeRight: " + imgDesc, Toast.LENGTH_SHORT).show();
    }
}