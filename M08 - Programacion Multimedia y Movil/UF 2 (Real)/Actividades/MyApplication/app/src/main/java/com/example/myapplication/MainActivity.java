package com.example.myapplication;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static boolean presionado = false;

    public static MediaRecorder md;
    public static final int REQUEST_AUDIO_PERMISSION_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestsPermissions();

        Toast.makeText(getApplicationContext(), Environment.getExternalStorageDirectory().getAbsolutePath(), Toast.LENGTH_LONG).show();
        Button button = findViewById(R.id.button);

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                md = new MediaRecorder();
//                md.setAudioSource(MediaRecorder.AudioSource.MIC);
//                md.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
//                md.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
//                md.setOutputFile(Environment.getExternalStorageDirectory().getAbsolutePath() + "/audio.3gp");
//
//                Toast.makeText(MainActivity.this, "The button is clicked", Toast.LENGTH_SHORT).show();
//                if(!presionado){
//                    try {
//                        md.prepare();
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                    md.start();
//                    presionado = true;
//                    Toast.makeText(MainActivity.this, "Esta grabando", Toast.LENGTH_LONG).show();
//                }else{
//                    try {
//                        md.stop();
//                        md.release();
//                        presionado = false;
//                        Toast.makeText(MainActivity.this, "La grabacion se ha parado", Toast.LENGTH_LONG).show();
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
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