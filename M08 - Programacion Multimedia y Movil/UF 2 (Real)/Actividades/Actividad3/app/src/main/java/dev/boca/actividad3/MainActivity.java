package dev.boca.actividad3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {

<<<<<<< HEAD
    public static boolean presionado = false;
    MediaRecorder md;
    public static final int REQUEST_AUDIO_PERMISSION_CODE = 1;

=======
>>>>>>> 859c23c2c1f88af46db4d0b13bd9471e5b99e0b8
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        RequestsPermissions();

        Toast.makeText(getApplicationContext(), Environment.getExternalStorageDirectory().getAbsolutePath(), Toast.LENGTH_LONG).show();
        Button button = findViewById(R.id.button);

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
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    md.start();
                    presionado = true;
                    Toast.makeText(MainActivity.this, "Esta grabando", Toast.LENGTH_SHORT).show();
                }else{
                    md.stop();
                    md.release();
                    md = null;
                    presionado = false;
                    Toast.makeText(MainActivity.this, "Esta grabando", Toast.LENGTH_SHORT).show();
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
=======
>>>>>>> 859c23c2c1f88af46db4d0b13bd9471e5b99e0b8
    }
}