package dev.boca.actividad3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toolbar;

import java.util.Timer;
import java.util.TimerTask;

public class ChargeActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charge);

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(ChargeActivity.this, TabLayoutActivity.class);
                startActivity(intent);
                finish();
            }
        };

        ImageView imageView = findViewById(R.id.foto);
        rotarImagen(imageView);

        Timer timer = new Timer();
        timer.schedule(tarea, 7000);


    }

    public void rotarImagen(ImageView imageView){
        RotateAnimation animation = new RotateAnimation(0, 360,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        animation.setDuration(3000);
        animation.setRepeatCount(1);
        animation.setRepeatMode(Animation.REVERSE);
        imageView.startAnimation(animation);
    }

}