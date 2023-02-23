package dev.boca.actividad3;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean presionado;
    MediaRecorder md;
    public static final int REQUEST_AUDIO_PERMISSION_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestsPermissions();

        Toast.makeText(getApplicationContext(), Environment.getExternalStorageDirectory().getAbsolutePath(), Toast.LENGTH_LONG).show();
        Button button = findViewById(R.id.button);

        presionado = false;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(!presionado){
                    md = new MediaRecorder();
                    md.setAudioSource(MediaRecorder.AudioSource.MIC);
                    md.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                    md.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                    md.setOutputFile(Environment.getExternalStorageDirectory().getAbsolutePath() + "/audio.3gp");


                    try {
                        md.prepare();
                        md.start();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    presionado = true;
                }else{
                    try {
                        md.stop();
                        md.release();
                        presionado = false;
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                Toast.makeText(MainActivity.this, "The button is clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void RequestsPermissions(){
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{RECORD_AUDIO, WRITE_EXTERNAL_STORAGE}, REQUEST_AUDIO_PERMISSION_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_AUDIO_PERMISSION_CODE:
                if (grantResults.length > 0) {
                    boolean permissionToRecord = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean permissionToStore = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    if (permissionToRecord && permissionToStore)
                        Toast.makeText(getApplicationContext(), "Permission Granted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getApplicationContext(), "Permission Denied", Toast.LENGTH_LONG).show();

                }
                break;
        }
    }
}